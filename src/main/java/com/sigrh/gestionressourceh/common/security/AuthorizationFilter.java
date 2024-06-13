package com.sigrh.gestionressourceh.common.security;

import java.io.IOException;

//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import com.sigrh.gestionressourceh.common.util.TokenUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {
	protected static final String AUTHORIZATION_HEADER = HttpHeaders.AUTHORIZATION;
	protected static final String TOKEN_PREFIX = "Bearer ";
	private final TokenUtil tokenUtil;
	private final SigrhUserDetailsService userDetailsService;

	public AuthorizationFilter(TokenUtil tokenUtil, SigrhUserDetailsService userDetailsService) {
		this.tokenUtil = tokenUtil;
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String tokenHeader = request.getHeader(AUTHORIZATION_HEADER);
		String username = null;
		String token = null;

		if (!StringUtils.isEmpty(tokenHeader) && tokenHeader.startsWith(TOKEN_PREFIX)) {
			token = tokenHeader.substring(7);
			username = tokenUtil.getUsernameFromToken(token);
		}
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			if (tokenUtil.validateToken(token, userDetails)) {
				authentication(request, userDetails);
			} else {
				throw new InsufficientAuthenticationException("Informations invalides");
			}
		}
      filterChain.doFilter(request, response);
	}

	private static void authentication(HttpServletRequest request, UserDetails userDetails) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,
				userDetails.getPassword(), userDetails.getAuthorities());
		authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	}


}

package net.gestion.pgremuneration.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

@Component
public class TokenUtil {

	protected static final long EXPIRATION_TIME = 364_000_000;
	protected static final String SECRET = "a5f24718-2ffe-4e06-8f07-9f5fc6611da4";

	public Date getExpirationDateFromToken(final String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	private <T> T getClaimFromToken(final String token, final Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(final String token) {
		return Jwts.parser().setSigningKey(SECRET).build().parseClaimsJws(token).getBody();
	}

	public String getToken(final UserDetails userDetails) {
		String subject = userDetails.getUsername();
		List<GrantedAuthority> authorities = new ArrayList<>(userDetails.getAuthorities());
		return generateToken(subject, authorities);
	}

	private String generateToken(final String subject, final List<GrantedAuthority> authorities) {
		return Jwts.builder().setSubject(subject).claim("authorities", authorities)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, SECRET).compact();
	}

	public Boolean validateToken(final String token, final UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	public String getUsernameFromToken(final String token) {
		try {
			return getClaimFromToken(token, Claims::getSubject);
		} catch (Exception e) {
			return null;
		}
	}

	private Boolean isTokenExpired(final String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

}

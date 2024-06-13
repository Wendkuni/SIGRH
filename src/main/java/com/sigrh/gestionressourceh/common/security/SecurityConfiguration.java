package com.sigrh.gestionressourceh.common.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@Profile("!test")
public class SecurityConfiguration {
	protected static final String SWAGGER_UI = "/swagger-ui/**";
	protected static final String OPEN_API_DOCS = "/v3/api-docs/**";

	private final SigrhAuthenticationProvider authProvider;
	private final AuthorizationFilter authorizationFilter;

	public SecurityConfiguration(SigrhAuthenticationProvider authProvider,
                                 AuthorizationFilter authorizationFilter) {
		this.authProvider = authProvider;
		this.authorizationFilter = authorizationFilter;
	}

	@Bean
	public AuthenticationManager authManager(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder =
				http.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.authenticationProvider(authProvider);
		return authenticationManagerBuilder.build();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	http.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(authorize ->
						authorize.requestMatchers("/v1/api/user/login",SWAGGER_UI,OPEN_API_DOCS).permitAll()
						.anyRequest()
						.authenticated()
				)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authProvider);
		 http.addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class);
		 return http.build();
	}



}

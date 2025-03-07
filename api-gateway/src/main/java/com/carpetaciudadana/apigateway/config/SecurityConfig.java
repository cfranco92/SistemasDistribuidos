package com.carpetaciudadana.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		
		//Todas las solicitudes deben venir autenticadas
		http.authorizeExchange(exchange -> exchange.pathMatchers("/*/actuator/**").permitAll(). anyExchange().authenticated())
			.oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);
		
		http.csrf().disable();
		return http.build();
		
	}
}
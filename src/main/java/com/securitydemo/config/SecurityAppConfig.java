package com.securitydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityAppConfig {

	@Autowired
	HttpSecurity httpSecurity;

	@Bean
	public UserDetailsManager setUpUser() {
		UserDetails userDetails1 = User
				.withUsername("abhishek")
				.password("{bcrypt}$2a$10$JePFsJap8pEZJhp2SFyA5.kx7m3CIFGFllJwIEYmBRtuGbY6Ivvg6")
				.roles("admin", "user")
				.build();

		UserDetails userDetails2 = User
				.withUsername("rahul")
				.password("{noop}rahul")
				.roles("user")
				.build();

		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	@Bean
	public SecurityFilterChain settingUpSecurityFilterChain() throws Exception {
		httpSecurity.authorizeHttpRequests().requestMatchers("/hi").authenticated();
		httpSecurity.authorizeHttpRequests().requestMatchers("/bye").permitAll();
		httpSecurity.authorizeHttpRequests().requestMatchers("/hello").denyAll();
		httpSecurity.formLogin();
		httpSecurity.httpBasic();
		return httpSecurity.build();
	}
	
	@Bean(name="mvcHandlerMappingIntrospector")
	HandlerMappingIntrospector handlerMappingIntrospecor() {
		return new HandlerMappingIntrospector();
	}

}

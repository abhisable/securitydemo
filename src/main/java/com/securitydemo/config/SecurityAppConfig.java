package com.securitydemo.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityAppConfig {

	@Bean
	public UserDetailsManager setUpUser() {
		UserDetails userDetails1= User
				.withUsername("abhishek")
				.password("{bcrypt}$2a$10$JePFsJap8pEZJhp2SFyA5.kx7m3CIFGFllJwIEYmBRtuGbY6Ivvg6")//{noop} is password incoder here using this we can remove PaswordEncoder bean
				.roles("admin","user")
				.build();
		
		UserDetails userDetails2=User 
				.withUsername("rahul")
				.password("{noop}rahul")
				.roles("user")
				.build();
		
		return new InMemoryUserDetailsManager(userDetails1,userDetails2);

//		GrantedAuthority role1 = new SimpleGrantedAuthority("User");
//		GrantedAuthority role2 = new SimpleGrantedAuthority("Admin");
//		ArrayList<GrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(role1);
//		authorities.add(role2);
//
//		UserDetails userDetails = new User("abhishek", "abhishek", authorities);
//
//		UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//		userDetailsManager.createUser(userDetails);
//
//		return userDetailsManager;
	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}

}

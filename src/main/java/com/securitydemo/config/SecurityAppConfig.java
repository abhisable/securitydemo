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

		GrantedAuthority role1 = new SimpleGrantedAuthority("User");
		GrantedAuthority role2 = new SimpleGrantedAuthority("Admin");
		ArrayList<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(role1);
		authorities.add(role2);

		UserDetails userDetails = new User("abhishek", "abhishek", authorities);

		UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
		userDetailsManager.createUser(userDetails);

		return userDetailsManager;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}

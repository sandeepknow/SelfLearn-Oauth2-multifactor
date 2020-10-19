package com.bootcamp.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration extends GlobalAuthenticationConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("admin"))
//				.roles("USER", "ADMIN", "MANAGER").authorities("CAN_READ", "CAN_WRITE", "CAN_DELETE").and()
//				.withUser("username").password(passwordEncoder.encode("password")).roles("USER")
//				.authorities("CAN_READ");

		// This part does not use encoder
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("USER", "ADMIN", "MANAGER")
//				.authorities("CAN_READ", "CAN_WRITE", "CAN_DELETE").and().withUser("username")
//				.password("{noop}password").roles("USER").authorities("CAN_READ");

		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);

	}

}

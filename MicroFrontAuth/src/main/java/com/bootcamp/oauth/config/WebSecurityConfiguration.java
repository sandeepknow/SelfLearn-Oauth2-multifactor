package com.bootcamp.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@Order(1)
public class WebSecurityConfiguration //extends WebSecurityConfigurerAdapter
{

//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin")
		.roles("USER", "ADMIN", "MANAGER").authorities("CAN_READ", "CAN_WRITE", "CAN_DELETE").and()
		.withUser("username").password("{noop}password").roles("USER")
		.authorities("CAN_READ");
	}
}

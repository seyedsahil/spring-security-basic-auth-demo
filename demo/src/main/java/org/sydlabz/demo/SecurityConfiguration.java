package org.sydlabz.demo;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// @formatter:off
		httpSecurity
			.authorizeRequests()
			.antMatchers("/api/v1/demo/list/resource").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/api/v1/demo/list/resource/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
			.anyRequest().authenticated()
				.and()
			.httpBasic();
		// @formatter:on
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		// @formatter:off
		authenticationManagerBuilder
			.inMemoryAuthentication()
			.withUser("admin").password("{noop}test").roles("ADMIN")
				.and()
			.withUser("user").password("{noop}test").roles("USER");
		// @formatter:on
	}

}

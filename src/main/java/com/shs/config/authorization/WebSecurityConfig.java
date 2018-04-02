/**
 * Web security configuration with dataSource access
 * .antMatchers("/login/**") used for redirecting to the default Spring login window
 */
package com.shs.config.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery(
						"select username,password, enabled from users where username=?")
				.authoritiesByUsernameQuery(
						"select username, role from user_roles where username=?");
	}

	/*Only for debugging uses not encoding pass authentication.
	Since Spring-5.0.0 changes the default password method to encoding;*/
	@SuppressWarnings("deprecation")
	@Bean
	public NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/login/**").access("hasRole('ROLE_USER')")
				.antMatchers("/login/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/login/**").access("hasRole('ROLE_MANAGER')")
				.antMatchers("/view-bicycle-modify/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/view-clothes-modify/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/manage-order/**").access("hasRole('ROLE_MANAGER')")
				.and().logout().logoutSuccessUrl("/view-item")
				.and().exceptionHandling().accessDeniedPage("/403")
				.and().formLogin().defaultSuccessUrl("/", false);
	}
}
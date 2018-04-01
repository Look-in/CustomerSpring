package com.shs.config.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		auth.inMemoryAuthentication().withUser("manager").password("manager").roles("MANAGER");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	}

	/*Only for debuggin. Since Spring 5.0.0 changes the default password method to encoding;*/
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
				.antMatchers("/viewbicyclemodify/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/viewclothesmodify/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/admin-item/**").access("hasRole('ROLE_SUPERADMIN')")
				.and().formLogin().defaultSuccessUrl("/", false);
	}
}

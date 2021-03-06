package com.etca.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import javax.sql.DataSource;
import com.etca.service.EtcaUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;

	@Autowired
	private EtcaUserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder builder)
		throws Exception
	{
		builder.userDetailsService(userDetailsService);

		builder
			.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(new BCryptPasswordEncoder());
	}


	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http
			.authorizeRequests()
			.antMatchers("/", "/index/**", "/home/**", "/user/register", 
				"/word/**","/lesson/**", "/grammar/**","/error", "/user/login",
				"/api/lesson/**", "/user/index","/css/*","/js/*")
				.permitAll()
			.anyRequest().authenticated()
			.and()
			.exceptionHandling().accessDeniedPage("/error")
			.and()
			.formLogin()
				.loginPage("/user/login")
				.permitAll()
			.and()
			.logout()
				.permitAll();
	}
}
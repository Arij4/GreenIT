package com.vermeg.greenit.profilesecurity;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.User.UserBuilder;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.web.SecurityFilterChain;

@Configuration

@EnableWebSecurity

public class SecurityConfiguration {

	@Bean

	public UserDetailsService userDetailsService() throws Exception {

// ensure the passwords are encoded properly

		@SuppressWarnings("deprecation")
		UserBuilder users = User.withDefaultPasswordEncoder();

		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

		manager.createUser(users.username("user").password("password").roles("ADMIN").build());

		manager.createUser(users.username("admin").password("password").roles("USER").build());
		manager.createUser(users.username("arij").password("tic").roles("ADMIN").build());

		return manager;

	}

	@Bean

	public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {

		http.cors().disable().antMatcher("/profile/**")

				.authorizeHttpRequests(authorize -> authorize

						.anyRequest().hasRole("ADMIN")

				)

				.httpBasic().and().csrf().disable().cors().disable();

		return http.build();

	}

}

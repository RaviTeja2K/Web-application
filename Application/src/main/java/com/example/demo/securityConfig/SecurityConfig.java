package com.example.demo.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.repository.EmployerDaoRepo;

@Configuration
public class SecurityConfig {

	@Autowired
	static EmployerDaoRepo employerDaoRepo;

//	define user to access api's
	@Bean
	public UserDetailsService userDetailsService() {

		
		UserDetails details = User.withUsername("ravi")
								.password(passwordEncoder().encode("ravi"))
								.roles("Admin")
								.build();
		
	InMemoryUserDetailsManager inMemoryUserDetailsManager =	new InMemoryUserDetailsManager(details);
		return inMemoryUserDetailsManager;

	}
	
	
//	access users from Database
//	@Bean
//	public UserDetailsService userDetailsService1() {
//		return new CustomeUsersDetailsService();
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

// filter Api's 

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
		.authorizeHttpRequests()
//		.requestMatchers("/api/get/{id}")    // role base
//		.hasRole("Admin")
//		.requestMatchers("/api/getall")
		.requestMatchers("/api/**")
		.permitAll();
//		.anyRequest()
//		.authenticated().and().formLogin();
		return httpSecurity.build();
	}

}

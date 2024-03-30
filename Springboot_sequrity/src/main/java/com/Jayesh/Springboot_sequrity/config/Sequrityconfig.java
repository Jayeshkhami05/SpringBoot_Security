package com.Jayesh.Springboot_sequrity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Sequrityconfig {

	// used for authrations APi
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.authorizeHttpRequests(resitry->{
			resitry.requestMatchers("/Jayesh/public").permitAll();
			resitry.requestMatchers("/Jayesh/admin").hasRole("admin");
			resitry.requestMatchers("/Jayesh/user").hasRole("user");			
		}).formLogin(AbstractAuthenticationFilterConfigurer::permitAll).build();
	}
	
	// used for authacating API 
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails userDetails1=User.builder().username("Yuvraj").password(passwordEncoder().encode("Yuvraj@123")).roles("admin").build();
		UserDetails userDetails2=User.builder().username("Jayesh").password(passwordEncoder().encode("Jayesh@1234")).roles("user").build();
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}
	
	// used for encodeing direct string password 
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

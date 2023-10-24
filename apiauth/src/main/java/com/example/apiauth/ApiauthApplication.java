package com.example.apiauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.RememberMeServices;

@SpringBootApplication
public class ApiauthApplication {
	public static void main(String[] args) {
		var encoder = new BCryptPasswordEncoder();
		var password = encoder.encode("888888");
		System.out.println("{bcrypt}" + password);
		//{bcrypt}$2a$10$TxykBThXW2brNleo1QDvbeDd4TIJJVgl9QakUHGc.deaucHVWyEHK
		//{bcrypt}$2a$10$f4aQLof9kgM8mzJIP7a.Vuc3WYcQK8brcL6hrHdCdkzTH8AppEpOm
		SpringApplication.run(ApiauthApplication.class, args);
	}

	@Autowired
	private ConfigurableBeanFactory beanFactory;

	@Bean("securityFilterChain")
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		var chain = http
		        .authorizeHttpRequests(customizer -> customizer
		            .requestMatchers("/api/csrf").permitAll()
		            .requestMatchers("/api/login").permitAll()
		            .requestMatchers("/api/**").authenticated()
		            .anyRequest().denyAll())
		        .exceptionHandling(customizer -> customizer
		            .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
		        .rememberMe(customizer -> customizer.alwaysRemember(true).key("demo"))
		        .build();
		System.out.println("chain: " + chain.getFilters());
		var rememberMeServices = http.getSharedObject(RememberMeServices.class);
		beanFactory.registerSingleton("rememberMeServices", rememberMeServices);

		return chain;
	}
}

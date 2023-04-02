package com.mjzf.bloggers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@SpringBootApplication
public class BloggersApiApplication{

	public static void main(String[] args) {
		SpringApplication.run(BloggersApiApplication.class, args);
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
		.httpBasic().and().csrf().disable()
		.authorizeHttpRequests(authorize -> authorize
		        .anyRequest().permitAll()
		    );
		    return http.build();
	}
}

package com.SpringSecurity.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.SpringSecurity.Service.AccessUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class Config {
	
	//Authentication
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		
//		UserDetails user = User.withUsername("Deepak")
//				.password(encoder.encode("password1"))
//				.roles("USER")
//				.build();
//		
//		UserDetails admin = User.withUsername("Megu")
//				.password(encoder.encode("password2"))
//				.roles("ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user,admin);
		
		return new AccessUserDetailsService();
	}
	
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder(); 
	}
	
	
	//Authorization
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return	http.csrf(AbstractHttpConfigurer :: disable)
					.authorizeHttpRequests( auth -> auth.requestMatchers("/security/welcome","/security/access/add").permitAll()
											.requestMatchers("/security/**")
											.authenticated()
					)
					.httpBasic(Customizer.withDefaults()).build();		
	}
	
	
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		 
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
		
	}
	
}





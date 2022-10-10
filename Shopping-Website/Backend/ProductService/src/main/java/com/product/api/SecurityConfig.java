//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;

//package com.product.api;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.product.api.service.MyUserDetailService;
//
//
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//@Autowired
//private MyUserDetailService myUserDetailService;
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(getAuthProvider());
//		
//	}
//	private AuthenticationProvider getAuthProvider() {
//		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//		auth.setUserDetailsService(myUserDetailService);
//		auth.setPasswordEncoder(getPassEncoder());
//		return auth;
//		}
//@Override
//protected void configure(HttpSecurity http) throws Exception{
//	http.authorizeRequests()
//			.antMatchers(HttpMethod.POST,"/product").hasAnyAuthority("ADMIN")
//			.antMatchers(HttpMethod.GET,"/product").permitAll()
//			.antMatchers(HttpMethod.PUT,"/product/{pid}").hasAnyAuthority("ADMIN")
//			.antMatchers(HttpMethod.Delete,"/product/{pid}").hasAnyAuthority("ADMIN")
//	@Bean
//	public PasswordEncoder getPassEncoder() {
//		PasswordEncoder encoder= new BCryptPasswordEncoder();
//		return encoder;
//		
//	}
//}

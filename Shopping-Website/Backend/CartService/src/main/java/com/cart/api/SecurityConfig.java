package com.cart.api;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.cart.api.service.MyUserDetailsService;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getAuthProvider());
				
	}
	
	private AuthenticationProvider getAuthProvider() {
		DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
		auth.setUserDetailsService(myUserDetailsService);
		auth.setPasswordEncoder(getPassEncoder());
		return auth;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()

						.antMatchers(HttpMethod.GET,"/cart/allcart").permitAll()
						.antMatchers(HttpMethod.GET,"/cart/item/**").permitAll()

						.antMatchers(HttpMethod.GET,"/cart/allcart").authenticated()

						.antMatchers(HttpMethod.POST,"/cart/user").permitAll()
						.antMatchers(HttpMethod.POST,"/cart/saveItem/**").permitAll()
						.antMatchers(HttpMethod.GET,"/cart/user/**").authenticated()
						.antMatchers(HttpMethod.POST,"/cart/addcart").permitAll()
						.antMatchers(HttpMethod.PUT,"/updatecart/**").authenticated()
						.antMatchers(HttpMethod.DELETE,"/cart/deletecart/**").authenticated()

						.antMatchers(HttpMethod.POST,"/cart/sms").permitAll()


						.antMatchers(HttpMethod.GET,"/allcart").authenticated()

						.anyRequest().permitAll()
						.and().httpBasic()
						.and().csrf().disable();
	}
	
	@Bean
	public PasswordEncoder getPassEncoder(){
		
		return NoOpPasswordEncoder.getInstance();
	}
}

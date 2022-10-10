package com.cart.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.context.annotation.Bean;
//import org.springframework.http.ResponseEntity;


//import org.springframework.context.annotation.Bean;
//import org.springframework.http.ResponseEntity;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;




//import org.springframework.web.client.RestTemplate;

//import com.cart.api.repository.UserRepository;

//import com.cart.api.repository.UserRepository;


import org.springframework.web.client.RestTemplate;

import com.cart.api.repository.UserRepository;





@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private com.cart.api.repository.UserRepository userRepository;

	
	//@Autowired
	//private RestTemplate restTemplate;



	//@Autowired
	//private RestTemplate restTemplate;

	@Autowired
	private RestTemplate restTemplate;

	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		// checking the details by making call to profile service because it is managing all the users.




		//ResponseEntity<com.cart.api.model.User> temp=restTemplate
			//	.getForEntity("http://localhost:1200/u/user/"+username, com.cart.api.model.User.class);
		//com.cart.api.model.User userDB=temp.getBody();
		
		

		com.cart.api.model.User userDB=userRepository.findByUsername(username);  

		//com.cart.api.model.User userDB=userRepository.findByUsername(username);  

		ResponseEntity<com.cart.api.model.User> temp=restTemplate
				.getForEntity("http://localhost:1200/u/user/"+username, com.cart.api.model.User.class);
		com.cart.api.model.User user=temp.getBody();
		
		
		//com.wallet.api.model.User userDB=userRepository.findByUsername(username);  

		 if(userDB==null) throw new UsernameNotFoundException("Invalid Username");
		 
				 
		 List<GrantedAuthority> list=new ArrayList<>();
		 SimpleGrantedAuthority sga=new SimpleGrantedAuthority(userDB.getRole());
		 list.add(sga);
		 
		 User springuser=new User(userDB.getUsername(),userDB.getencrytedPassword(),list);
		return  springuser;
	}

}

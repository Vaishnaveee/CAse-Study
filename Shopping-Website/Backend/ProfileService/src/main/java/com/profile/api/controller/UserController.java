package com.profile.api.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.profile.api.model.User;
import com.profile.api.repository.UserRepository;


@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	RestTemplate restTemplate=new RestTemplate();

	
	
	//@Autowired
	//private PasswordEncoder passwordEncoder;

	/*
	 * @GetMapping("/hello") public String gethello() {
	 * 
	 * return "hello user"; }
	 */
	// post method to add new user
	
	
	@GetMapping("/gitlogin")
	public String message(Principal principal) {
		return "Hi "+principal.getName()+" welcome to SpringCloudOauth2ExampleApplication";
	}
	
	@GetMapping("/user")
	public String message1(Principal principal) {
		return "Hi "+principal.getName()+" welcome ";
	}
	
	
	  @PostMapping("/users")
	 public User adduser(@RequestBody User user) { 
		
	    user.setRole("user");
	    return userRepository.save(user);
//		user=userRepository.save(user);
	    
//	    restTemplate.getForObject("http://localhost:1000/wallet/saveWallet/"+user.getUserId(), com.profile.api.model.Wallet.class);
//	    restTemplate.getForObject("http://localhost:1000/cart/addcart/"+user.getUserId(), com.profile.api.model.Cart.class);
//		
//	    
//	  return user ; 
	  }
	  
	  @PostMapping("/admin")
		 public User addadmin(@RequestBody User user) { 
			
		    user.setRole("admin");
		  return userRepository.save(user); 
		  }
	

	// get method to get all users list
	@GetMapping("/user1")
	public List<User> getalluser() {

		return userRepository.findAll();
	}

	// delete method to delete user using user ID
	@DeleteMapping("/user/{uid}")
	public void deleteuser(@PathVariable("uid") Long uid) {
		userRepository.deleteById(uid);
	}

	
	@GetMapping("/user/u/{username}")
	public User getByUsername(@PathVariable("username") String username) {
		
		User user= userRepository.findByUsername(username);
	    
		return user;	
	}
	
	/*
	 * @GetMapping("/user/{mobilenumber}") public User
	 * getByUsermobile(@PathVariable("mobilenumber") String mobilenumber) {
	 * 
	 * User user= userRepository.findByMobilenumber(mobilenumber);
	 * 
	 * return user; }
	 */
	
	@GetMapping("/user/{id}")
	public User getByUserId(@PathVariable("id") long id) {
		
		User user= userRepository.getById(id);
	
		return user;
	}
	
	// put method to update user according to user ID
	@PutMapping("/user/update/{uid}")
	public User updateuser(@PathVariable("uid") Long uid, @RequestBody User newuser) {

		User userDB = userRepository.getById(uid);

		if (newuser.getFirstname() != null)
			userDB.setFirstname(newuser.getFirstname());

		if (newuser.getLastname() != null)
			userDB.setLastname(newuser.getLastname());
		
		if (newuser.getUsername() != null)
			userDB.setUsername(newuser.getUsername());

		/*
		 * if (newuser.getMobilenumber() != null)
		 * userDB.setMobilenumber(newuser.getMobilenumber());
		 */

		/*
		 * if (newuser.getGender()!= null) userDB.setGender(newuser.getGender());
		 */

		if (newuser.getEncrytedPassword()!= null)
			userDB.setEncrytedPassword(newuser.getEncrytedPassword());
		

		/*
		 * if (newuser.getEmail()!= null)
		 * userDB.setDateOfBirth(newuser.getDateOfBirth());
		 */
		if (newuser.getEmail() != null)
			userDB.setEmail(newuser.getEmail());
		/*
		 * if (newuser.getUsername() != null) userDB.setUsername(newuser.getUsername());
		 */

		return userRepository.save(userDB);
	}
	
	

}
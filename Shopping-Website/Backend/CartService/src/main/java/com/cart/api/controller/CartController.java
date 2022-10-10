package com.cart.api.controller;

import java.util.ArrayList;
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

import com.cart.api.model.Cart;
import com.cart.api.model.Items;
import com.cart.api.model.SmsModel;
import com.cart.api.repository.CartRepository;
import com.cart.api.repository.ItemRepository;
import com.cart.api.repository.UserRepository;

import com.cart.api.model.User;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@CrossOrigin(origins = {"http://localhost:4200/"})
@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ItemRepository itemRepository;
	
	
	// display the records from  cart
	@GetMapping("/allcart")
	@ApiOperation(value="find all product in the cart",
	response=Cart.class)
	public List<Cart> getCart() {
		
		return cartRepository.findAll();
	}
	
	
	//posting the records in the cart
	@PostMapping("/addcart")
	@ApiOperation(value="add product in the cart",
	response=Cart.class)
	public Cart postCart(@RequestBody Cart cart)
	{
		return cartRepository.save(cart);
		
	}
	
	
	//update cart
	@PutMapping("/updatecart/{cId}")
	@ApiOperation(value="update cart by id",
	notes = "provide an id of the cart and update it",
	response=Cart.class)
	public Cart updateCart(@ApiParam(value="ID value for updation you need to be retrive",required = true) @PathVariable("cId") Long cId, @RequestBody Cart cart) {
		Cart cart1=cartRepository.getReferenceById(cId);
		
		if(cart.getTotalPrice()!=0)
		{
			cart1.setTotalPrice(cart.getTotalPrice());
		  
		}

		return cartRepository.save(cart1);
	}
	
	
	//delete product in cart using cart id
	@DeleteMapping("/deletecart/{cId}")
	@ApiOperation(value="deletet product by id",
	notes = "provide an id of the product and delete it",
	response=Cart.class)
	public List<Cart> deleteCart(@ApiParam(value="ID value for deletion you need to be retrive",required = true) @PathVariable("cId") Long cId){
		cartRepository.deleteById(cId);
		return cartRepository.findAll();
	}
	
	
	
	// fetch cart using userId
	
//	@GetMapping("/getcart/{uId}")
//	public Cart getCartByUserId(@PathVariable("uId") Long uId) 
//	{
//		RestTemplate restTemplate=new RestTemplate();
//        User user=restTemplate.getForObject("http://localhost:1000/user/"+uId, User.class);
//		
//		if(user.getUserId()!=0) return cartRepository.getByUserId(uId);
//		return new Cart();
//		
//		
//	}
	
	
	
	//post product in cart using userId
	
	@GetMapping("/addcart/{uId}")
	public Cart postCart(@PathVariable("uId") Long uId) {
		
      Cart cart=new Cart();
      cart.setUserId(uId);
		return cartRepository.save(cart);
		//return new Cart();
	}
	
	//delete waleet by userid
	
	@DeleteMapping("/deleteCart/{uId}")// delete the existent wallet
	public List<Cart> deleteCartByUserId(@PathVariable("uId") Long uId){
		Cart cart1=cartRepository.getByUserId(uId);
		if(cart1.getId() !=0 ) cartRepository.deleteById(uId);
		return cartRepository.findAll();
	}
	
	
	
	@GetMapping("/getItemsByCart/{cId}")
	public List<Items> getItemsByCartId(@PathVariable("cId") Long cId) {
		Cart cart1=cartRepository.getReferenceById(cId);

		return itemRepository.findAllByCart(cart1);
	}
	
	

	/*
	@PostMapping("/user")
	public void postuser(@RequestBody User user)
	{
		userRepository.save(user);
	}
	
	*/
	
	@GetMapping("/{uid}")
	public Long getCartByUserId(@PathVariable("uid") Long uid )
	{
		Cart cart=cartRepository.getByUserId(uid);
		return cart.getId();
	}
	
	@GetMapping("/getcart/{cid}")
	public Cart getCartById(@PathVariable("cid")Long cid)
	{
		return cartRepository.getReferenceById(cid);
	}
	/*//sms service
	@Autowired
	SmsService smsService;
	@PostMapping("/sms")
	public void postSms(@RequestBody SmsModel sms)
	{
		smsService.send(sms);
	}
	
	
	*/
	

}

package com.order.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.order.api.model.Address;
import com.order.api.model.Cart;
import com.order.api.repository.AddressRepository;
import com.order.api.repository.CartRepository;
import com.order.api.repository.OrderRepository;

@CrossOrigin(origins = {"http://localhost:4200/"})
@RestController
@RequestMapping("/order")
public class AddressController {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	
	@Autowired
	private CartRepository cartRepository;
	
	
	@GetMapping("/getaddress")		//APi to fetch all Address
	public List<Address> getAllAddress(){
		return addressRepository.findAll();
	}
	
	@PostMapping("/storeaddress/{cid}")  //Api to Store a new Address
	public Address storeAddress(@RequestBody Address address,@PathVariable("cid")Long cid) {
		
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<com.order.api.model.Cart> temp = restTemplate
				.getForEntity("http://localhost:1003/cart/getcart/"+cid, Cart.class);
		
		Cart cartDb = temp.getBody();
		address.setCartId((long)cartDb.getId());
		
		
		return addressRepository.save(address);
	}
	
	@GetMapping("/address/{cid}")		//Api to fetch all the address by the customer ID
	public Address getAddressByCustomerId(@PathVariable("cid") Long cid){
		return addressRepository.getReferenceById(cid);
	}
	
}

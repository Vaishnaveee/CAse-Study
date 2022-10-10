package com.cart.api.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cart.api.model.Cart;
import com.cart.api.model.Items;
import com.cart.api.model.Product;
import com.cart.api.repository.CartRepository;
import com.cart.api.repository.ItemRepository;


import io.swagger.v3.oas.annotations.parameters.RequestBody;
@CrossOrigin(origins = {"http://localhost:4200/"})
@RestController
@RequestMapping("/cart")
public class ItemController {
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@GetMapping("/allItems")// get all Items
	public List<Items> getItems() {
		return itemRepository.findAll();
	}
	
//	@GetMapping("/{iid}")// get items by id
//	public Items getStatementById(@PathVariable("iid") Long iid) {
//		return itemRepository.getReferenceById(iid);
//	}
	
    @PostMapping("/saveItem/{cid}/{pid}")// post the Item by cart Id
	public Items postItem(@RequestBody Items item,@PathVariable("cid") Long cid,@PathVariable("pid") Long pid) {
		Cart cart1=cartRepository.getById(cid);
		
		ResponseEntity<com.cart.api.model.Product> temp=restTemplate
				.getForEntity("http://localhost:1002/product/cart/"+pid, com.cart.api.model.Product.class);
		com.cart.api.model.Product proDB=temp.getBody();

    	//cart1.setTotalPrice(item.getPrice()*item.getQuantity());
		item.setProductId((long)proDB.getId());
		item.setCart(cart1);	
		List<Items> iList=itemRepository.getItemsByCart(cid);
		double price=cart1.getTotalPrice();
		for(int i=0;i<iList.size();i++) {
			ResponseEntity<com.cart.api.model.Product> temp1=restTemplate
					.getForEntity("http://localhost:1002/product/cart/"+pid, com.cart.api.model.Product.class);
			com.cart.api.model.Product proDB1=temp.getBody();
			price+=proDB1.getPrice();
		}
		
		cart1.setTotalPrice(price);
		return itemRepository.save(item);
	}
	
	@DeleteMapping("/deleteItem/{cId}/{pId}")// delete the existent Item
	public void deleteItem(@PathVariable("cId") Long cId,@PathVariable("pId") Long pId){
		Items item1=itemRepository.getBycId(cId,pId);
		 itemRepository.delete(item1);
		//return itemRepository.findAll();
	}
	
	
	
	@GetMapping("/item/{cid}")
	public List<Product> getItemByCart(@PathVariable("cid")Long cId) {
		
		Cart cart1=cartRepository.getById(cId);
		List<Long> item1= new ArrayList<>();
		item1=itemRepository.getproductId(cId);
		
		//return itemRepository.getItemsByCart(cId);
		List<Product> product1= new ArrayList<>();
		double price=cart1.getTotalPrice();
		
		for(int i=0;i<item1.size();i++) {
			ResponseEntity<com.cart.api.model.Product> temp1=restTemplate
					.getForEntity("http://localhost:1002/product/cart/"+item1.get(i), com.cart.api.model.Product.class);
			com.cart.api.model.Product proDB1=temp1.getBody();
			product1.add(proDB1);
			price+=proDB1.getPrice();
		}
		cart1.setTotalPrice(price);
		System.out.println(product1);
		return product1;
		
		
	}
	@DeleteMapping("/deleteItem/{cId}")
	public void deleteItemsByCartId(@PathVariable("cId")Long cId)
	{
		List<Items>item1=itemRepository.getItemsByCart(cId);
		itemRepository.deleteAll(item1);
	}

}

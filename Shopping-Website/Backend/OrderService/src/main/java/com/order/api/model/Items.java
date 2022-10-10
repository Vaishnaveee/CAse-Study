package com.order.api.model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Items {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private Long productId;
	//private String productName;
	
	//private double price;
	//private int quantity=1;
	//private int quantity;
	//@ManyToMany(mappedBy ="items" )
	//private List<Cart> cart;
	
	@OneToOne
	private Cart cart;

	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Items(Long id, Long productId, Cart cart) {
		super();
		Id = id;
		this.productId = productId;
		this.cart = cart;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
}
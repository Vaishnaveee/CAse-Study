package com.order.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false,unique = true)
	private Long cartId;
	
	@Column(nullable = false)
	private String fullName;
	
	@Column(nullable = false,unique = true)
	private String mobileNumber;
	
	@Column(nullable = false)
	private int flatNumber;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private int pincode;
	
	@Column(nullable = false)
	private String state;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(Long id, Long cartId, String fullName, String mobileNumber, int flatNumber, String city, int pincode,
			String state) {
		super();
		this.id = id;
		this.cartId = cartId;
		this.fullName = fullName;
		this.mobileNumber = mobileNumber;
		this.flatNumber = flatNumber;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

}

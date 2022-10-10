package com.product.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
     private int userId;
	@Column(nullable = false)
	private String username;
	private String password;
	@Column(nullable = false)
	private String Address;
	@Column(nullable = false)
	private String role;
	
	private String mobile;
	
	private int age;
	
 @Column(nullable = false)
	private String email;

public User(int userId, String username, String password,String address, String role, String mobile, int age, String email) {
	this.userId = userId;
	this.username = username;
	this.password=password;
	this.Address = address;
	this.role = role;
	this.mobile = mobile;
	this.age = age;
	this.email = email;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public User() {
	super();
	// TODO Auto-generated constructor stub
}




public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getusername() {
	return username;
}

public void setusername(String username) {
	username = username;
}

public String getAddress() {
	return Address;
}

public void setAddress(String address) {
	Address = address;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

}


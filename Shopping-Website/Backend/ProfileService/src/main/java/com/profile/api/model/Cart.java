package com.profile.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Cart {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)	
private Long id;
@Column(nullable = false)
private Long userId;

private double totalPrice;



public Cart() {
	
}

public Cart(Long id, Long userId, double totalPrice) {
	
	this.id = id;
	this.userId = userId;
	this.totalPrice = totalPrice;
	
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}


public Long getUserId() {
	return userId;
}

public void setUserId(Long userId) {
	this.userId = userId;
}

public double getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}







}

package com.profile.api.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@ApiModelProperty(notes="the id of the each Wallet is unique")
	private Long id;
	
	@Column(nullable = false, unique = true)
	private Long userId;
	//@ApiModelProperty(notes="Balance in wallet")
	private int balance=0;
	private int activate=0;
	

	
	
	public Wallet() {
		super();
	}
	
	
	public Wallet(Long id, Long userId, int balance, int activate) {
		super();
		this.id = id;
		this.userId = userId;
		this.balance = balance;
		this.activate = activate;
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
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int isActivate() {
		return activate;
	}
	public void setActivate(int activate) {
		this.activate = activate;
	}

	
	
	
}

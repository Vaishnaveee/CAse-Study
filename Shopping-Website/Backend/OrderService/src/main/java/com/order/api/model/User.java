package com.order.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
	@Column(nullable = false)
	private String username;
	private String encrytedPassword;
	@Column(nullable = false)
	private String firstname;
	@Column(nullable = false)
	private String lastname;
	@Column(nullable = false)
	private String role;
	private String mobilenumber;
	private String gender;
	@Column(nullable = false)
	private String email;
	
	
	public User() {
		super();
	}


	public User(Long userId, String username, String encrytedPassword, String firstname, String lastname, String role,
			String mobilenumber, String gender, String email) {
		this.userId = userId;
		this.username = username;
		this.encrytedPassword = encrytedPassword;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
		this.mobilenumber = mobilenumber;
		this.gender = gender;
		this.email = email;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getencrytedPassword() {
		return encrytedPassword;
	}


	public void setencrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getMobilenumber() {
		return mobilenumber;
	}


	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	
	
}
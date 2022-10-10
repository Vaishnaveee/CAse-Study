
package com.shoppingcartgateway.api.model;

import java.time.LocalDate;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

//@Entity
public class User {

	// user table coloumn entites

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes="the id of the each product is unique")
	private int profileId;

//	@Column(nullable = false)
	@ApiModelProperty(notes="Name of user")
	private String fullName;

	@ApiModelProperty(notes="Mobile no of user")
	private String mobilenumber;

//	@Column(nullable = false)
	@ApiModelProperty(notes="Role of user")
	private String role;
	@ApiModelProperty(notes="Gender of user")
	private String gender;

	private String about;
	@ApiModelProperty(notes="Password of user")
	private String password;
	@ApiModelProperty(notes="DOB of user")
	private LocalDate dateOfBirth;
	@ApiModelProperty(notes="Gmail of user")
//	@Column(nullable = false)
	private String emailId;
	@ApiModelProperty("Username of user")
	private String username;

	
	
	public User() {
		
	}

	

	public User(int profileId, String fullName, String mobilenumber, String role, String gender, String about,
			String password, LocalDate dateOfBirth, String emailId, String username) {
		super();
		this.profileId = profileId;
		this.fullName = fullName;
		this.mobilenumber = mobilenumber;
		this.role = role;
		this.gender = gender;
		this.about = about;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.username = username;
	}



	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	

	public String getMobilenumber() {
		return mobilenumber;
	}



	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}



	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	@Override
	public String toString() {
		return "User [profileId=" + profileId + ", fullName=" + fullName + ", mobilenumber=" + mobilenumber + ", role="
				+ role + ", gender=" + gender + ", about=" + about + ", password=" + password + ", dateOfBirth="
				+ dateOfBirth + ", emailId=" + emailId + ", username=" + username + "]";
	}



	

	

	

}

package com.product.api;


public class InvalidException extends RuntimeException{

	
	String message="Can't Be null";

	public String getMessage() {
		return message;
	}
	
}
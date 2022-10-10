package com.order.api.dto;

import java.time.LocalDate;

public class OrderDto {
	
	private Long id;
	private String productTitle;
	private double price;
	private LocalDate date;
	private String modeOfPayment;
	private String orderStatus;
	
	
	
	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDto(Long id, String productTitle, double price, LocalDate date, String modeOfPayment,
			String orderStatus) {
		super();
		this.id = id;
		this.productTitle = productTitle;
		this.price = price;
		this.date = date;
		this.modeOfPayment = modeOfPayment;
		this.orderStatus = orderStatus;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	
}

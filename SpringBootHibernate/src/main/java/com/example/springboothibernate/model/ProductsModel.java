package com.example.springboothibernate.model;

import javax.persistence.Id;


public class ProductsModel {

	@Id
	private int productId;
	
	private String productName;
	
	private Long productAmount;
	
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Long getProductAmount() {
		return productAmount;
	}
	
	public void setProductAmount(Long productAmount) {
		this.productAmount = productAmount;
	}
	
	
}

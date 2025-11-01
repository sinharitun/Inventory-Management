package com.learn.management;

public class Product {
	
	//Instance Variable declaration
	private int id;
	private String productName;
	private int quantity;
	private double price;
	
	//Constructor without id for Insert data
	public Product(String productName, int quantity, double price) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}
	
	//Constructor with id to fetch all data from database
	public Product(int id, String productName, int quantity, double price) {
		super();
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}
	
	
	// getter and setter methods to access the instance variable
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	// String method to display the result
	
	@Override
	public String toString() {
		return String.format("%3d %25s %4d %2.f", this.id,this.productName,this.quantity,this.price);
	}
	

}

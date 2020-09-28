package com.thewalking.model;

import org.springframework.stereotype.Component;
public class Item implements Cloneable{
	private Product product;
	private int qty;
	public Item(){
		
	}

	public Item(Product product, int qty) {
		super();
		this.product = product;
		this.qty = qty;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Item [product=" + product + ", qty=" + qty + "]";
	}
	public Object clone() throws CloneNotSupportedException 
	{ 
		return super.clone(); 
	}
	
}

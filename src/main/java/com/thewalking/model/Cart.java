package com.thewalking.model;

import java.util.Set;
public class Cart{
	private Set<OrderItem> items;
	private Payment payment;
    private String shippingAddress;
    private String shippingZipcode;
    private String shippingName;
	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getShippingZipcode() {
		return shippingZipcode;
	}

	public void setShippingZipcode(String shippingZipcode) {
		this.shippingZipcode = shippingZipcode;
	}

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Cart() {
		
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	public Cart(Set<OrderItem> items) {
		super();
		this.items = items;
	}

	@Override
	public String toString() {
		return "Cart [items=" + items + ", payment=" + payment + ", shippingAddress=" + shippingAddress
				+ ", shippingZipcode=" + shippingZipcode + ", shippingName=" + shippingName + "]";
	}
	
	
	
}

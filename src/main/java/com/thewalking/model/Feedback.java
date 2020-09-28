package com.thewalking.model;

public class Feedback {
	private int order_id;
	private String message;
	public Feedback() {
	}
	
	public Feedback(int order_id, String message) {
		super();
		this.order_id = order_id;
		this.message = message;
	}

	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}

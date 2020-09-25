package com.thewalking.model;

import java.util.Set;
public class Cart{
	private Set<Item> items;
	
	public Cart() {
		
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Cart(Set<Item> items) {
		super();
		this.items = items;
	}

	@Override
	public String toString() {
		return "Cart [items=" + items + "]";
	}
	
	
	
}

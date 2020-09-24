package com.thewalking.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "carts")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @Column(name="cart_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@OneToMany(mappedBy="cart")
	private Set<Item> items;
//	Order order;
	//User user;
	
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

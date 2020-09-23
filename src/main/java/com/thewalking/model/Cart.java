package com.thewalking.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	Map<Product, Integer> map;
	public Cart() {
		map = new HashMap<Product, Integer>();
	}
	
	public Map<Product, Integer> getMap() {
		return map;
	}

	public void setMap(Map<Product, Integer> map) {
		this.map = map;
	}
	public void updateCart(Product p, int quantity) {
		map.put(p, quantity);
	}

	public void addCart(Product product, int quantity) {
		if (map.containsKey(product)) {
			int oldQ = map.get(product);
			map.put(product, oldQ+quantity);
		}else {
			map.put(product, quantity);
		}
	}
	
}

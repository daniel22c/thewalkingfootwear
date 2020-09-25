package com.thewalking.jpa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thewalking.model.Cart;
import com.thewalking.model.Order;
import com.thewalking.model.OrderItem;
import com.thewalking.model.Product;

@Service
public class CartService {
	@Autowired
	OrderService orderService;
	@Autowired
	OrderItemService orderItemService;
	@Transactional
	public Order submit_cart_order(Cart cart) {
		if (cart==null) {
			return null;
		}
		HashMap<Product, Integer> map = (HashMap<Product, Integer>) cart.getMap();
		Iterator itr = map.entrySet().iterator();
		Order order = new Order();
		while(itr.hasNext()) {
			Map.Entry element = (Map.Entry) itr.next();
			Product prod = (Product) element.getKey();
			int qty = (int) element.getValue();
			OrderItem item = new OrderItem(order, qty, prod);
			orderItemService.save(item);
		}
		orderService.save(order);
		return order;
	}

}

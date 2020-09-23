package com.thewalking.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thewalking.model.Order;
import com.thewalking.model.OrderItem;

public class OrderItemService {
	@Autowired
	OrderItemRepository orderItemRepo;
	public List<OrderItem> findAll(){
		return orderItemRepo.findAll();
	}
	public OrderItem save(OrderItem orderItem) {
		return orderItemRepo.save(orderItem);
	}
}

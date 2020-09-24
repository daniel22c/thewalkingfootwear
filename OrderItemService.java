package com.thewalking.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thewalking.model.Order;
import com.thewalking.model.OrderItem;
@Service
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

package com.thewalking.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thewalking.model.Order;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepo;
	public List<Order> findAll(){
		return orderRepo.findAll();
	}
	public Order save(Order order) {
		return orderRepo.save(order);
	}
}

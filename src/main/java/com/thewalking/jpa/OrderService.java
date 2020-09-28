package com.thewalking.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thewalking.model.Cart;
import com.thewalking.model.Item;
import com.thewalking.model.Order;
import com.thewalking.model.OrderItem;
import com.thewalking.model.Payment;
import com.thewalking.model.Product;

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
	public Order submitOrder(Order order) {
		return orderRepo.save(order);
		
	}
	public void deleteById(int id) {
		orderRepo.deleteById(id);
	}
	public Optional<Order> findById(int id) {
		return orderRepo.findById(id);
	}
	public Order update(Order order) {
		return orderRepo.save(order);
	}
}

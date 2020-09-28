package com.thewalking.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thewalking.model.Cart;
import com.thewalking.model.Feedback;
import com.thewalking.model.Item;
import com.thewalking.model.Order;
import com.thewalking.model.OrderItem;
import com.thewalking.model.OrderStatus;
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
		order.newOrderUUID();
		order.newTimeStamp();
		order.newOrderStatus();
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
	public Order cancelOrder(int id) {
		Optional<Order> opOrder = findById(id);
		if(opOrder.isPresent()) {
			Order order = opOrder.get();
			if(order.getStatus()==OrderStatus.SUBMITTED) {
				order.setStatus(OrderStatus.CANCELLED); 
				save(order);
				return order;
			}else {
				//TODO throw error. if the order is shipped or delivered, it cannot be cancelled
			}
		}
		return null;
	}
	public Order returnOrder(int id) {
		Optional<Order> opOrder = findById(id);
		if(opOrder.isPresent()) {
			Order order = opOrder.get();
			if(order.getStatus()==OrderStatus.DELIVERED) {
				order.setStatus(OrderStatus.RETURNREQUESTED); 
				save(order);
				return order;
			}else {
				//TODO throw error if return is attempted for orders that has not been delivered
			}
		}
		return null;
	}
	public Order setOrderStatusToDelivered(int id) {
		Optional<Order> opOrder = findById(id);
		if(opOrder.isPresent()) {
			Order order = opOrder.get();
			if(order.getStatus()==OrderStatus.SHIPPED) {
				order.setStatus(OrderStatus.DELIVERED); 
				save(order);
				return order;
			}else {
				//TODO throw error if return is attempted for orders that has not been delivered
			}
		}
		return null;
	}
	public Order feedbackOrder(Feedback feedback) {
		Optional<Order> opOrder = findById(feedback.getOrder_id());
		if(opOrder.isPresent()) {
			Order order = opOrder.get();
			if(order.getStatus()==OrderStatus.DELIVERED) {
				order.setFeedback(feedback.getMessage());
				save(order);
				return order;
			}else {
				//TODO throw error if feedback is attempted for orders that has not been delivered
			}
		}
		return null;
	}
}

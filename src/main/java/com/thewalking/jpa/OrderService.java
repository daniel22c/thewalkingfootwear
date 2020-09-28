package com.thewalking.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thewalking.model.Cart;
import com.thewalking.model.Item;
import com.thewalking.model.Order;
import com.thewalking.model.OrderItem;
import com.thewalking.model.Payment;

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
//		Payment payment = cart.getPayment();
////		List<OrderItem> cartItems = (List<OrderItem>) cart.getItems();
//		String shippingAddress =cart.getShippingAddress();
//		String shippingZipcode = cart.getShippingZipcode();
//		String shippingName = cart.getShippingName();
////		List<OrderItem> orderItems = new ArrayList<OrderItem>();
//		//TODO get address from cart
//		//TODO clone orderitems to items list
//		Order order = new Order(payment, cart.getItems(), shippingAddress, shippingZipcode, shippingName);
//		//set order object and save
		return orderRepo.save(order);
		
	}
}

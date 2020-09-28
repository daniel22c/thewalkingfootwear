package com.thewalking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thewalking.jpa.OrderService;
import com.thewalking.model.Feedback;
import com.thewalking.model.Order;
import com.thewalking.model.OrderStatus;
import com.thewalking.model.Product;

@CrossOrigin
@RestController
@RequestMapping(value="/API/orders")
public class OrderRestController {
	@Autowired
	OrderService orderService;
	@GetMapping(value="/all", produces = "application/json")
	public  List<Order> findAllOrders() {
		return orderService.findAll();
	}
	
	@PostMapping(value="/submitOrder", consumes = "application/json", produces="application/json")
	public Order create(@RequestBody Order order) {
		return orderService.submitOrder(order);
	}
	@DeleteMapping(value="/delete/{id}",produces = "application/json")
	public void deleteProduct(@PathVariable int id) {
		orderService.deleteById(id);
	}
	@GetMapping(value="/order_details/{id}", produces = "application/json")
	public Order order_details(@PathVariable int id) {
		Optional<Order> opOrder = orderService.findById(id);
		if (opOrder.isPresent()) {
			return opOrder.get();
		}
		return null;
	}
	@PutMapping(value="/update",consumes = "application/json" ,produces = "application/json")
	public Order updateOrder(@RequestBody Order order) {
		return orderService.update(order);
	}
	
	@PutMapping(value="/cancelOrder/{id}",consumes = "application/json" ,produces = "application/json")
	public Order cancelOrder(@PathVariable int id) {
		return orderService.cancelOrder(id);
	}
	
	@PutMapping(value="/returnOrder/{id}",consumes = "application/json" ,produces = "application/json")
	public Order returnOrder(@PathVariable int id) {
		return orderService.cancelOrder(id);
	}
	@PutMapping(value="/setOrderDelivered/{id}",consumes = "application/json" ,produces = "application/json")
	public Order setOrderDelivered(@PathVariable int id) {
		return orderService.setOrderStatusToDelivered(id);
	}
	@PostMapping(value="/feedback",consumes = "application/json" ,produces = "application/json")
	public Order returnOrder(@RequestBody Feedback feedback) {
		return orderService.feedbackOrder(feedback);
	}
	
}

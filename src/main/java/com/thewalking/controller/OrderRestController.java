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
import com.thewalking.model.Order;
import com.thewalking.model.Product;

@CrossOrigin
@RestController
@RequestMapping(value="/API/orders")
public class OrderRestController {
	@Autowired
	OrderService orderService;
	@GetMapping(value="/all", produces = "application/json")
	public  List<Order> findAllProduct() {
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
	public Order updateProduct(@RequestBody Order order) {
		return orderService.update(order);
	}
	
	
	
}

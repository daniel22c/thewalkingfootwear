package com.thewalking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thewalking.jpa.OrderService;
import com.thewalking.model.Cart;
import com.thewalking.model.Order;
@CrossOrigin
@RestController
@RequestMapping(value="/API/cart")
public class CartRestController {
	@Autowired
	OrderService orderService;
	
	@PostMapping(value="/submitOrder", consumes = "application/json", produces="application/json")
	public Order submit_order(@RequestBody Order order) {
		return orderService.submitOrder(order);
	}
}

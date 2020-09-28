package com.thewalking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thewalking.jpa.OrderService;
import com.thewalking.model.Order;

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
}

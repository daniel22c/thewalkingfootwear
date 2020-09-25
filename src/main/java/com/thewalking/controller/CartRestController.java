package com.thewalking.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thewalking.model.Cart;
import com.thewalking.model.Payment;
@CrossOrigin
@RestController
@RequestMapping(value="/API/cart")
public class CartRestController {
//	@Autowired
//	OrderService orderService;
	
	@PostMapping(value="/submitOrder", consumes = "application/json", produces="application/json")
	public Cart submit_order(@RequestBody Cart cart, @RequestBody Payment payment) {
		return cart;
	}
}

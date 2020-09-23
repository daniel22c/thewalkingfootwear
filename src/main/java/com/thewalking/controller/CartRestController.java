package com.thewalking.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.thewalking.jpa.CartService;
import com.thewalking.jpa.OrderService;
import com.thewalking.jpa.ProductService;
import com.thewalking.model.Cart;
import com.thewalking.model.Category;
import com.thewalking.model.Order;
import com.thewalking.model.Product;

@RestController
@RequestMapping(value="/cart")
public class CartRestController {
	@Autowired
	CartService cartService;
	
	@PostMapping(value="/submit_order",consumes = "application/json" , produces = "application/json")
	public Order submit_cart_order(Cart cart) {
		return cartService.submit_cart_order(cart);
	}
}

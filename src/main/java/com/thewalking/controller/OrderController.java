package com.thewalking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thewalking.jpa.CategoryService;
import com.thewalking.jpa.OrderService;
import com.thewalking.jpa.ProductService;
import com.thewalking.model.Category;
import com.thewalking.model.Product;

@Controller
@RequestMapping(value="/orders")
public class OrderController {
	@Autowired
	ProductService pService;
	@Autowired
	CategoryService cService;
	@Autowired
	OrderService oService;
	
}

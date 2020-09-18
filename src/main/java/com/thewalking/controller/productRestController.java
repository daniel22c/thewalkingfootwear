package com.thewalking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thewalking.jpa.ProductService;
import com.thewalking.model.Product;

@RestController
@RequestMapping(value="/API/products") //  /API/products
public class productRestController {
	@Autowired
	ProductService pService;

	@GetMapping(value="/all", produces = "application/json")
	public  List<Product> findAllProduct() {
		System.out.println("###");
		return pService.findAll("");
	}
	@GetMapping("/find/{id}")
	public Product findProduct(@PathVariable int id) {
		return pService.find(id);
	}
	@GetMapping("/find")
	public Product findOne(@RequestParam("id") int id) {
		return pService.find(id);
	}
}

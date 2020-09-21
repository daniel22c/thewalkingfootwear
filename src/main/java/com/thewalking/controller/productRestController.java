package com.thewalking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thewalking.jpa.ProductService;
import com.thewalking.model.Product;
@CrossOrigin
@RestController
@RequestMapping(value="/API/products") //  /API/products
public class productRestController {
	@Autowired
	ProductService pService;

	@GetMapping(value="/all", produces = "application/json")
	public  List<Product> findAllProduct() {
		return pService.findAll("");
	}
	@GetMapping(value="/find/{id}", produces = "application/json")
	public Product findProduct(@PathVariable int id) {
		return pService.find(id);
	}
	@GetMapping(value= "/find", produces = "application/json")
	public Product findOne(@RequestParam("id") int id) {
		return pService.find(id);
	}
	@PutMapping(value="/update",produces = "application/json",method=RequestMethod.PUT)
	public Product updateProduct(Product product) {
		return pService.update(product);
	}
	
	@DeleteMapping(value="/delete/{id}",produces = "application/json")
	public void deleteProduct(@PathVariable int id) {
		pService.deleteById(id);
	}
	
	@PostMapping(value="/create",consumes = "application/json" , produces = "application/json")
	public Product createProduct(Product product) {
		return pService.save(product);
	}
}

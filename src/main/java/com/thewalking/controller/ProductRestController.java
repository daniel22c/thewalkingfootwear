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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thewalking.jpa.CategoryService;
import com.thewalking.jpa.ProductService;
import com.thewalking.model.Category;
import com.thewalking.model.Product;
@CrossOrigin
@RestController
@RequestMapping(value="/API/products")
public class ProductRestController {
	@Autowired
	ProductService pService;
	@Autowired
	CategoryService categoryService;

	@GetMapping(value="/all", produces = "application/json")
	public  List<Product> findAllProduct() {
		return pService.findAll("");
	}
	@GetMapping(value="/findByCategoryId/{category_id}", produces = "application/json")
	public List<Product> listByCategory(@PathVariable int category_id) {
		return pService.findByCategoryId(category_id);
	}
	@GetMapping(value="/prod_details/{id}", produces = "application/json")
	public Product prod_details(@PathVariable int id) {
		return pService.find(id);
	}
	@GetMapping(value= "/find", produces = "application/json")
	public Product findOne(@RequestParam("id") int id) {
		return pService.find(id);
	}
	@GetMapping(value="/categories", produces = "application/json")
	public List<Category> findAll_Categories() {
		return categoryService.all();
	}
	
	@PutMapping(value="/update",consumes = "application/json" ,produces = "application/json")
	public Product updateProduct(@RequestBody Product product) {
		System.out.println("###"+product);
		return pService.update(product);
	}
	
	@DeleteMapping(value="/delete/{id}",produces = "application/json")
	public void deleteProduct(@PathVariable int id) {
		pService.deleteById(id);
	}
	
	@PostMapping(value="/create",consumes = "application/json" , produces = "application/json")
	public Product createProduct(@RequestBody Product product) {
		return pService.save(product);
	}
}

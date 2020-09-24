package com.thewalking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thewalking.jpa.CategoryService;
import com.thewalking.jpa.ProductService;
import com.thewalking.model.Category;
import com.thewalking.model.Product;

@CrossOrigin
@RestController
@RequestMapping(value="/API/categories")
public class CategoryRestController {
	@Autowired
	CategoryService cService;

	@GetMapping(value="/all", produces = "application/json")
	public  List<Category> findAllCategory() {
		return cService.all();
	}
		
	@PutMapping(value="/update",consumes = "application/json" ,produces = "application/json")
	public Category updateCategory(@RequestBody Category category) {
		return cService.update(category);
	}
	
	@DeleteMapping(value="/delete/{id}",produces = "text/plain")
	public String deleteCategory(@PathVariable int id) {
		cService.deleteById(id);
		return "deleted";
	}
	
	@PostMapping(value="/create",consumes = "application/json" , produces = "application/json")
	public Category createCategory(@RequestBody Category category) {
		return cService.save(category);
	}
}

package com.thewalking.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thewalking.model.Category;
import com.thewalking.model.Product;
@Service
public class CategoryService {
	@Autowired
	CategoryRepository cRepo;

	public List<Category> all() {
		return cRepo.findAll();
	}
	@Transactional
	public Category update(Category category) {
		return cRepo.save(category);
	}
	@Transactional
	public void deleteById(int id) {
		cRepo.deleteById(id);
	}
	@Transactional
	public Category save(Category category) {
		return cRepo.save(category);
	}

}

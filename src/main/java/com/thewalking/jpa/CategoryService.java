package com.thewalking.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thewalking.model.Category;
@Service
public class CategoryService {
	@Autowired
	CategoryRepository cRepo;

	public List<Category> all() {
		return cRepo.findAll();
	}
}

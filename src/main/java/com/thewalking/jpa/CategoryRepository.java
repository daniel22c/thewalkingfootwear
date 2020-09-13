package com.thewalking.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thewalking.model.Category;
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	public List<Category> findAll();
//	@Query("SELECT c FROM Category c")
//	public List<Category> search(); 
}

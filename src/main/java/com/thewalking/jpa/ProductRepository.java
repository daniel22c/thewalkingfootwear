package com.thewalking.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.thewalking.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	public List<Product> findAll();
	@Query("SELECT p FROM Product p where CAST(p.id as string) = ?1"
			+ " or p.name like %?1%")
	public List<Product> search(String q); 
	@Query("select p from Product p where p.category_id = ?1")
	public List<Product> findByCategoryId(int id);
}

package com.thewalking.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thewalking.model.Product;
@Service
public class ProductService {
	@Autowired
	ProductRepository prodRepo;

	public List<Product> findAll(String keyword) {
        if (keyword != null) {
            return prodRepo.search(keyword);
        }
        return prodRepo.findAll();
    }
	public List<Product> findByCategoryId(int catId) {
		return prodRepo.findByCategoryId(catId);
	}
	public Product find(int id) {
		Product p = new Product();
		Optional<Product> op = prodRepo.findById(id);
		if (op.isPresent()) {
			p = op.get();
		}
		return p;
	}
	public Product update(Product product) {
		return prodRepo.save(product);
	}
	public void deleteById(int id) {
		prodRepo.deleteById(id);
	}
	public Product save(Product product) {
		return prodRepo.save(product);
	}
}

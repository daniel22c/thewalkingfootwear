package com.thewalking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name = "products")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @Column(name="product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="product_name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="category_id", nullable=false)
	private Category category;
	
	@OneToOne
	@JoinColumn(name="product")
	private OrderItem orderItem;
	public Product() {
	}
	
	public Product(String name, Category category) {
		super();
		this.name = name;
		this.category = category;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + "]";
	}
	

	
}

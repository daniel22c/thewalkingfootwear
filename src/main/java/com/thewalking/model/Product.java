package com.thewalking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "products")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @Column(name="product_id")
	private int id;
	@Column(name="product_name")
	private String name;
	private int category_id;
//	private Category category;
	public Product(int id, String name, int category_id) {
		super();
		this.id = id;
		this.name = name;
		this.category_id = category_id;
	}
	public Product() {
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
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category_id=" + category_id + "]";
	}
	
}

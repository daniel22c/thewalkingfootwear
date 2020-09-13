package com.thewalking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "categories")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @Column(name="category_id")
	private int id;
	@Column(name="category_name")
	private String name;
//	@OneToMany(orphanRemoval = true, mappedBy = "category", fetch = FetchType.LAZY)
//	private List<Product> prodList;
	public Category() {
		
	}
	
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
}

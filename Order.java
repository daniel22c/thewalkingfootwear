package com.thewalking.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "orders")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @Column(name="order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int user_id;
	private int status_id;
	private String order_uuid;
	//TODO add payment
	
//    @OneToMany(mappedBy = "order")
//    private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    private LocalDateTime timestamp;
 
	public Order() {
	}

	public Order(int id, int user_id, int status_id, String order_uuid, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.status_id = status_id;
		this.order_uuid = order_uuid;
		this.timestamp = timestamp;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder_uuid() {
		return order_uuid;
	}

	public void setOrder_uuid(String order_uuid) {
		this.order_uuid = order_uuid;
	}
	
}

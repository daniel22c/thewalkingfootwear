package com.thewalking.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Table(name = "orders")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @Column(name="order_id", updatable = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String order_uuid;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="payment_id")
	private Payment payment;
	
    @OneToMany(mappedBy="order",fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
    @ElementCollection(targetClass=OrderItem.class)
    private Collection<OrderItem> orderItems = new ArrayList<OrderItem>();
	
    private LocalDateTime timestamp;
    
    private String shippingAddress;
    private String shippingZipcode;
    private String shippingName;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private OrderStatus status;
    
    private String feedback;
    
    public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Collection<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(ArrayList<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getShippingZipcode() {
		return shippingZipcode;
	}

	public void setShippingZipcode(String shippingZipcode) {
		this.shippingZipcode = shippingZipcode;
	}

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public Order() {
	}
	public void newOrderUUID() {
		this.order_uuid = UUID.randomUUID().toString();
	}
	public void newTimeStamp() {
		this.timestamp = LocalDateTime.now();
	}
	public void newOrderStatus() {
		this.status = OrderStatus.SUBMITTED;
	}
	public Order(Payment payment, ArrayList<OrderItem> orderItems, 
			String shippingAddress, String shippingZipcode, String shippingName) {
		super();
		this.order_uuid = UUID.randomUUID().toString();
		this.payment = payment;
		this.orderItems = orderItems;
		this.timestamp = LocalDateTime.now();
		this.shippingAddress = shippingAddress;
		this.shippingZipcode = shippingZipcode;
		this.shippingName = shippingName;
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

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", order_uuid=" + order_uuid + ", payment=" + payment + ", orderItems=" + orderItems
				+ ", timestamp=" + timestamp + ", shippingAddress=" + shippingAddress + ", shippingZipcode="
				+ shippingZipcode + ", shippingName=" + shippingName + "]";
	}
	
}

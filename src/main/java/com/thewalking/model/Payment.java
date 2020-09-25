package com.thewalking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @Column(name="payment_id")
	private int id;
	private String paymentAddress;
	private String paymentName;
	private String paymentZipcode;
	private String cardno;
	
	@OneToOne
	@JoinColumn(name="order_id", nullable=false)
	Order order;
	public Payment() {}
	public Payment(String paymentAddress, String paymentName, String paymentZipcode, String cardno) {
		super();
		this.paymentAddress = paymentAddress;
		this.paymentName = paymentName;
		this.paymentZipcode = paymentZipcode;
		this.cardno = cardno;
	}
	public int getId() {
		return id;
	}
	public String getPaymentAddress() {
		return paymentAddress;
	}
	public void setPaymentAddress(String paymentAddress) {
		this.paymentAddress = paymentAddress;
	}
	public String getPaymentName() {
		return paymentName;
	}
	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}
	public String getPaymentZipcode() {
		return paymentZipcode;
	}
	public void setPaymentZipcode(String paymentZipcode) {
		this.paymentZipcode = paymentZipcode;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	

	
}

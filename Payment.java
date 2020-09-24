package com.thewalking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	private static final long serialVersionUID = 1L;
	@Id @Column(name="payment_id")
	private int id;
	@Column(name="payment_address")
	private String address;
	@Column(name="payment_name") //cardholder's name
	private String name;
	@Column(name="payment_zipcode")
	private String zipcode;
	@Column(name="payment_cardno")
	private String cardno;
//	private int order_id;
	
	@OneToOne
	@MapsId
	Cart cart;
	
	public Payment() {}
	public Payment(int id, String address, String name, String zipcode, String cardno) {
		super();
		this.id = id;
		this.address = address;
		this.name = name;
		this.zipcode = zipcode;
		this.cardno = cardno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", address=" + address + ", name=" + name + ", zipcode=" + zipcode + ", cardno="
				+ cardno + "]";
	}
	
}

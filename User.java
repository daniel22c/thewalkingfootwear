package com.thewalking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String firstName;
	private String lastName;
	private String streetShipAddress;
	private String cityShipAddress;
	private String zipcodeShipAddress;
	private String streetBillingAddress;
	private String cityBillingAddress;
	private String zipcodeBillingAddress;
	private String email;
	private String password;
	
	
}


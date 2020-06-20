package com.g2tech.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class PersonEntity {

	@Id
	@GeneratedValue
	long id;	
	String firstName;
	String lastName;
	
	@OneToOne(cascade = CascadeType.ALL)
	PhoneNumberEntity phoneNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	SupplierEntity supplier;
	
	@OneToOne(cascade = CascadeType.ALL)
	CustomerEntity customer;	
	
	public PhoneNumberEntity getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(PhoneNumberEntity phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public SupplierEntity getSupplier() {
		return supplier;
	}
	public void setSupplier(SupplierEntity supplier) {
		this.supplier = supplier;
	}
	public CustomerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}

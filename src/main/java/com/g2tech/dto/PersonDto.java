package com.g2tech.dto;

import com.g2tech.entity.CustomerEntity;
import com.g2tech.entity.PhoneNumberEntity;
import com.g2tech.entity.SupplierEntity;


public class PersonDto {
	
	long id;	
	String firstName;
	String lastName;
	
	PhoneNumberEntity phoneNumber;
	
	SupplierEntity supplier;
	
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

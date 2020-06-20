package com.g2tech.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "company")
public class CompanyEntity {

	@Id
	@GeneratedValue
	long id;	
	
	@NotEmpty(message = "Please provide a company name")
	String name;
	
	@NotEmpty(message = "Please provide a registration number")
	String registrationNumber;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	
}

package com.g2tech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="customer")
public class CustomerEntity {

	@Id
	@GeneratedValue
	long id;	
	
	@NotEmpty(message = "Please provide a customer name")
	String name;
	
	@NotEmpty(message = "Please provide a lastOrderDate")
	String lastOrderDate;
	
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
	public String getLastOrderDate() {
		return lastOrderDate;
	}
	public void setLastOrderDate(String lastOrderDate) {
		this.lastOrderDate = lastOrderDate;
	}	
	
}

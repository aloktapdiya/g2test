package com.g2tech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="supplier")
public class SupplierEntity {

	@Id
	@GeneratedValue
	long id;	
	
	@NotEmpty(message = "Please provide a tax number")
	String taxNumber;
	
	@NotEmpty(message = "Please provide a orderLeadTimeInDays")
	String orderLeadTimeInDays;
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTaxNumber() {
		return taxNumber;
	}
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	public String getOrderLeadTimeInDays() {
		return orderLeadTimeInDays;
	}
	public void setOrderLeadTimeInDays(String orderLeadTimeInDays) {
		this.orderLeadTimeInDays = orderLeadTimeInDays;
	}
		
}

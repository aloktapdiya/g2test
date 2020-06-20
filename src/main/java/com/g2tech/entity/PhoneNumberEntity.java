package com.g2tech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="phone_number")
public class PhoneNumberEntity {

	@Id
	@GeneratedValue
	long id;	
	
	@NotEmpty(message = "Please provide a areaCode")
	String areaCode;
	
	@NotEmpty(message = "Please provide a phone number")
	String number;
			
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}

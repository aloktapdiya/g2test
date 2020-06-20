package com.g2tech.service;

import java.util.List;

import com.g2tech.dto.PersonDto;
import com.g2tech.entity.PersonEntity;
import com.g2tech.exception.CompanyEntityNotFoundException;



public interface PersonDetailService {
	public void add(PersonDto personDto);
	public void delete(long id);
	public List<PersonEntity> getPersonDetails();
	public PersonEntity getPersonDetailById(long id) throws CompanyEntityNotFoundException;	
}

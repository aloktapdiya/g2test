package com.g2tech.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.g2tech.dao.CompanyRepository;
import com.g2tech.dao.PersonRepository;
import com.g2tech.dto.CompanyDto;
import com.g2tech.dto.PersonDto;
import com.g2tech.entity.CompanyEntity;
import com.g2tech.entity.PersonEntity;
import com.g2tech.exception.CompanyEntityNotFoundException;
import com.g2tech.service.CompanyDetailService;
import com.g2tech.service.PersonDetailService;

@Service
public class PersonDetailServiceImpl implements PersonDetailService {
	
	@Autowired
	PersonRepository repository;
	
	
	@Override
	public void add(PersonDto personDto) {
		repository.save(toEntity(personDto));
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

	@Override
	public List<PersonEntity> getPersonDetails() {
		return (List<PersonEntity>) repository.findAll();
	}

	@Override
	public PersonEntity getPersonDetailById(long id) throws CompanyEntityNotFoundException {
		Optional<PersonEntity> optionalLoadExcelEntity = repository.findById(id);
		return optionalLoadExcelEntity.orElseThrow(
				() -> new CompanyEntityNotFoundException("Couldn't find a PersonEntity with id: " + id));
	}

	private PersonEntity toEntity(PersonDto dto) {
		PersonEntity entity = new PersonEntity();
		entity.setCustomer(dto.getCustomer());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setSupplier(dto.getSupplier());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());		
		return entity;
	}

}

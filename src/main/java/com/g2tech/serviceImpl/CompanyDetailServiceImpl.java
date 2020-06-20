package com.g2tech.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.g2tech.dao.CompanyRepository;
import com.g2tech.dto.CompanyDto;
import com.g2tech.dto.PersonDto;
import com.g2tech.entity.CompanyEntity;
import com.g2tech.exception.CompanyEntityNotFoundException;
import com.g2tech.service.CompanyDetailService;

@Service
public class CompanyDetailServiceImpl implements CompanyDetailService {
	
	@Autowired
	CompanyRepository repository;
	
	@Override
	public void add(CompanyDto companyDto) {
		repository.save(toEntity(companyDto));
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

	@Override
	public List<CompanyEntity> getCompanyDetails() {
		return (List<CompanyEntity>) repository.findAll();
	}

	@Override
	public CompanyEntity getCompanyDetailById(long id) throws CompanyEntityNotFoundException {
		Optional<CompanyEntity> optionalLoadExcelEntity = repository.findById(id);
		return optionalLoadExcelEntity.orElseThrow(
				() -> new CompanyEntityNotFoundException("Couldn't find a CompanyEntity with id: " + id));
	}

	private CompanyEntity toEntity(CompanyDto dto) {
		CompanyEntity entity = new CompanyEntity();
		entity.setCustomer(dto.getCustomer());
		entity.setName(dto.getName());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setRegistrationNumber(dto.getRegistrationNumber());
		entity.setSupplier(dto.getSupplier());
		return entity;
	}
	
	private boolean validateRequest(Object obj) {
		boolean validateFlag = false;
		if(obj instanceof PersonDto) {
			PersonDto personDto = (PersonDto) obj;
			if(personDto.getSupplier() != null || personDto.getSupplier() != null) {
				validateFlag = true;
			} 
		} else if(obj instanceof CompanyDto) {
			CompanyDto companyDto = (CompanyDto) obj;
			if(companyDto.getSupplier() != null || companyDto.getSupplier() != null) {
				validateFlag = true;
			} 
		}
		return validateFlag;
	}
}

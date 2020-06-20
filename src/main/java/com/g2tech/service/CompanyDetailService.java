package com.g2tech.service;

import java.util.List;

import com.g2tech.dto.CompanyDto;
import com.g2tech.entity.CompanyEntity;
import com.g2tech.exception.CompanyEntityNotFoundException;



public interface CompanyDetailService {
	public void add(CompanyDto companyDto);
	public void delete(long id);
	public List<CompanyEntity> getCompanyDetails();
	public CompanyEntity getCompanyDetailById(long id) throws CompanyEntityNotFoundException;	
}

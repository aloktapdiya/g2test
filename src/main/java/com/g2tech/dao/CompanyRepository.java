package com.g2tech.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.g2tech.entity.CompanyEntity;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity, Long> {
	
}

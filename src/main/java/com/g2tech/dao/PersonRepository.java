package com.g2tech.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.g2tech.entity.PersonEntity;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {
	
}

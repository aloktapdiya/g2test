package com.g2tech.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.g2tech.dto.CompanyDto;
import com.g2tech.dto.PersonDto;
import com.g2tech.entity.CompanyEntity;
import com.g2tech.entity.PersonEntity;
import com.g2tech.service.CompanyDetailService;
import com.g2tech.service.PersonDetailService;


@RestController
public class ContactDetailController {
	private static final Logger logger = LoggerFactory.getLogger(ContactDetailController.class);
	@Autowired
	CompanyDetailService companyDetailService;
	
	@Autowired
	PersonDetailService personDetailService;
	

	@PostMapping("/company")
	public ResponseEntity<String> saveCompanyContact(@Valid @RequestBody CompanyDto companyDto) {
		logger.info("Entering in saveCompanyContact method");
		companyDetailService.add(companyDto);		
		return ResponseEntity.ok("Contact detail save successfully!");
	}
	
	@GetMapping("/company/details")
	public  ResponseEntity<List<CompanyEntity>> getCompanyContacts() {
		logger.info("Entering in getCompanyContacts method");		;
		return ResponseEntity.ok(companyDetailService.getCompanyDetails());
	}
	
	@PostMapping("/person")
	public ResponseEntity<String> savePersonContact(@Valid @RequestBody PersonDto personDto) {
		logger.info("Entering in saveCompanyContact method");
		personDetailService.add(personDto);	
		return ResponseEntity.ok("Contact detail save successfully!");
	}
	
	@GetMapping("/person/details")
	public ResponseEntity<List<PersonEntity>> getPersonContacts() {
		logger.info("Entering in getCompanyContacts method");		;
		return ResponseEntity.ok(personDetailService.getPersonDetails());
	}

}

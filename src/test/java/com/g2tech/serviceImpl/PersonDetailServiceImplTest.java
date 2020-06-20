package com.g2tech.serviceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.g2tech.dao.PersonRepository;
import com.g2tech.dto.PersonDto;
import com.g2tech.entity.CustomerEntity;
import com.g2tech.entity.PersonEntity;
import com.g2tech.entity.PhoneNumberEntity;
import com.g2tech.entity.SupplierEntity;
import com.g2tech.exception.CompanyEntityNotFoundException;
import com.g2tech.service.PersonDetailService;

@SpringBootTest
class PersonDetailServiceImplTest {

	@Autowired
	private PersonDetailService service;

	@MockBean
	private PersonRepository repository;

	@Test
	@DisplayName("Test findById Success")
	void testGetCompanyDetailById() throws CompanyEntityNotFoundException {
		// Setup our mock repository
		CustomerEntity customer = new CustomerEntity();
		customer.setId(1l);
		customer.setLastOrderDate("6jun");
		customer.setName("testname");
		PhoneNumberEntity phoneNumber = new PhoneNumberEntity();
		phoneNumber.setId(1l);
		phoneNumber.setAreaCode("areacode123");
		phoneNumber.setNumber("12345");
		SupplierEntity supplier = new SupplierEntity();
		supplier.setId(1l);
		supplier.setOrderLeadTimeInDays("28days");
		supplier.setTaxNumber("1234tax");
		PersonEntity personEntity = new PersonEntity();
		personEntity.setId(1l);
		personEntity.setFirstName("test");
		personEntity.setLastName("last");
		personEntity.setCustomer(customer);
		personEntity.setPhoneNumber(phoneNumber);
		personEntity.setSupplier(supplier);
		doReturn(Optional.of(personEntity)).when(repository).findById(1l);

		// Execute the service call
		PersonEntity person = service.getPersonDetailById(1l);

		// Assert the response
		Assertions.assertNotNull(person);
		Assertions.assertSame(person, personEntity);
	}
	
	@Test
	@DisplayName("Test findAll")
	void testFindAll() {
		// Setup our mock repository
		CustomerEntity customer = new CustomerEntity();
		customer.setId(1l);
		customer.setLastOrderDate("6jun");
		customer.setName("testname");
		PhoneNumberEntity phoneNumber = new PhoneNumberEntity();
		phoneNumber.setId(1l);
		phoneNumber.setAreaCode("areacode123");
		phoneNumber.setNumber("12345");
		SupplierEntity supplier = new SupplierEntity();
		supplier.setId(1l);
		supplier.setOrderLeadTimeInDays("28days");
		supplier.setTaxNumber("1234tax");
		PersonEntity personEntity = new PersonEntity();
		personEntity.setId(1l);
		personEntity.setFirstName("test");
		personEntity.setLastName("last");
		personEntity.setCustomer(customer);
		personEntity.setPhoneNumber(phoneNumber);
		personEntity.setSupplier(supplier);
		
		CustomerEntity customer2 = new CustomerEntity();
		customer2.setId(1l);
		customer2.setLastOrderDate("6jun");
		customer2.setName("testname");
		PhoneNumberEntity phoneNumber2 = new PhoneNumberEntity();
		phoneNumber2.setId(1l);
		phoneNumber2.setAreaCode("areacode123");
		phoneNumber2.setNumber("12345");
		SupplierEntity supplier2 = new SupplierEntity();
		supplier2.setId(1l);
		supplier2.setOrderLeadTimeInDays("28days");
		supplier2.setTaxNumber("1234tax");
		PersonEntity personEntity2 = new PersonEntity();
		personEntity2.setId(1l);
		personEntity2.setFirstName("test");
		personEntity2.setLastName("last");
		personEntity2.setCustomer(customer);
		personEntity2.setPhoneNumber(phoneNumber);
		personEntity2.setSupplier(supplier);
		
		doReturn(Arrays.asList(personEntity, personEntity2)).when(repository).findAll();

		// Execute the service call
		List<PersonEntity> personList = service.getPersonDetails();

		// Assert the response
		Assertions.assertEquals(2, personList.size(), "findAll should return 2 widgets");
	}

	
	void testAdd() {
		// Setup our mock repository
		CustomerEntity customer = new CustomerEntity();
		customer.setId(1l);
		customer.setLastOrderDate("6jun");
		customer.setName("testname");
		PhoneNumberEntity phoneNumber = new PhoneNumberEntity();
		phoneNumber.setId(1l);
		phoneNumber.setAreaCode("areacode123");
		phoneNumber.setNumber("12345");
		SupplierEntity supplier = new SupplierEntity();
		supplier.setId(1l);
		supplier.setOrderLeadTimeInDays("28days");
		supplier.setTaxNumber("1234tax");
		PersonDto personEntity = new PersonDto();
		personEntity.setId(1l);
		personEntity.setFirstName("test");
		personEntity.setLastName("last");
		personEntity.setCustomer(customer);
		personEntity.setPhoneNumber(phoneNumber);
		personEntity.setSupplier(supplier);
		doReturn(personEntity).when(repository).save(any());

		// Execute the service call

		service.add(personEntity);

		// Assert the response
		Assertions.assertNotNull(personEntity, "The saved companyEntity should not be null");
	}	

}

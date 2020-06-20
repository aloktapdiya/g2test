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

import com.g2tech.dao.CompanyRepository;
import com.g2tech.dto.CompanyDto;
import com.g2tech.entity.CompanyEntity;
import com.g2tech.entity.CustomerEntity;
import com.g2tech.entity.PhoneNumberEntity;
import com.g2tech.entity.SupplierEntity;
import com.g2tech.exception.CompanyEntityNotFoundException;
import com.g2tech.service.CompanyDetailService;

@SpringBootTest
class CompanyDetailServiceImplTest {

	@Autowired
	private CompanyDetailService service;

	@MockBean
	private CompanyRepository repository;

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
		CompanyEntity companyEntity = new CompanyEntity();
		companyEntity.setId(1l);
		companyEntity.setName("test");
		companyEntity.setRegistrationNumber("123456");
		companyEntity.setCustomer(customer);
		companyEntity.setPhoneNumber(phoneNumber);
		companyEntity.setSupplier(supplier);
		doReturn(Optional.of(companyEntity)).when(repository).findById(1l);

		// Execute the service call
		CompanyEntity company = service.getCompanyDetailById(1l);

		// Assert the response
		Assertions.assertNotNull(company);
		Assertions.assertSame(company, companyEntity);
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
		CompanyEntity companyEntity = new CompanyEntity();
		companyEntity.setId(1l);
		companyEntity.setName("test");
		companyEntity.setRegistrationNumber("123456");
		companyEntity.setCustomer(customer);
		companyEntity.setPhoneNumber(phoneNumber);
		companyEntity.setSupplier(supplier);

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
		CompanyEntity companyEntity2 = new CompanyEntity();
		companyEntity2.setId(1l);
		companyEntity2.setName("test");
		companyEntity2.setRegistrationNumber("123456");
		companyEntity2.setCustomer(customer);
		companyEntity2.setPhoneNumber(phoneNumber);
		companyEntity2.setSupplier(supplier);
		doReturn(Arrays.asList(companyEntity, companyEntity2)).when(repository).findAll();

		// Execute the service call
		List<CompanyEntity> companyList = service.getCompanyDetails();

		// Assert the response
		Assertions.assertEquals(2, companyList.size(), "findAll should return 2 widgets");
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
		CompanyDto companyEntity = new CompanyDto();
		companyEntity.setId(1l);
		companyEntity.setName("test");
		companyEntity.setRegistrationNumber("123456");
		companyEntity.setCustomer(customer);
		companyEntity.setPhoneNumber(phoneNumber);
		companyEntity.setSupplier(supplier);
		doReturn(companyEntity).when(repository).save(any());

		// Execute the service call

		service.add(companyEntity);

		// Assert the response
		Assertions.assertNotNull(companyEntity, "The saved companyEntity should not be null");
	}	

}

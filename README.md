1. Import as maven project

2. mysql should be on machine


3. Postman Request for crud ---
Company request :

{
	"name":"companyxyz",
	"registrationNumber":"12345",
	"phoneNumber": {
		"areaCode":"testareacode",
		"number":"123456"
	},
	"supplier": {
		"taxNumber":"12345",
		"orderLeadTimeInDays":"234"
	},
	"customer": {
		"name":"test",
		"lastOrderDate" :"6jun"
	}
	
}

Person Request
{
	"firstName":"ram",
	"lastName":"shyam",
	"phoneNumber": {
		"areaCode":"testareacode",
		"number":"123456"
	},
	"supplier": {
		"taxNumber":"12345",
		"orderLeadTimeInDays":"234"
	},
	"customer": {
		"name":"test",
		"lastOrderDate" :"6jun"
	}
	
}
















# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.1.14.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.7.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.7.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)


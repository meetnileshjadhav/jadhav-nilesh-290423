package com.avisys.cim;

import java.util.List;

public interface CustomerService {

	List<Customer> getAllCustomers();
	
	Customer getCustomerById(Long id);
	
	Customer getCustomerByMobileNumber(String mobileNumber);
	
	Customer getCustomerByFirstName(String firstName);
	
	List<Customer> getCustomerByLastName(String lastName);
}

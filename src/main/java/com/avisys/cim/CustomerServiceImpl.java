package com.avisys.cim;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}
	
	@Override
	public Customer getCustomerById(Long id) {
		Customer customer = this.customerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer","customer", id));
		return customer;
	}

	@Override
	public Customer getCustomerByMobileNumber(String mobileNumber) {
		Customer customer = this.customerRepo.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Customer", "mobile number", mobileNumber));
		return customer;
	}


	@Override
	public Customer getCustomerByFirstName(String firstName) {
		Customer customer = this.customerRepo.findByFirstNameIgnoreCaseContaining(firstName).orElseThrow(() -> new ResourceNotFoundException("Customer", "customer name", firstName));
		return customer;
	}

	@Override
	public List<Customer> getCustomerByLastName(String lastName) {
		List<Customer> list = this.customerRepo.findByLastNameIgnoreCaseContaining(lastName);
		return list;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		Customer customerSave = this.customerRepo.save(customer);
		return customerSave;
	}

}

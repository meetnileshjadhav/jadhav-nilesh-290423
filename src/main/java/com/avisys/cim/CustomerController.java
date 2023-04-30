package com.avisys.cim;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	//1. Get Methods
	
	@GetMapping("/getall")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return ResponseEntity.ok(this.customerService.getAllCustomers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCutomerById(@PathVariable Long id){
		return ResponseEntity.ok(customerService.getCustomerById(id));
	}
	
	@GetMapping("/mobile/{mobileNumber}")
	public ResponseEntity<Customer> getCustomerByMobile(@PathVariable String mobileNumber){
		return ResponseEntity.ok(customerService.getCustomerByMobileNumber(mobileNumber));
	}
	
	@GetMapping("/firstname")
	public ResponseEntity<Customer> findByFirstNameIgnoreCaseContaining(@RequestParam(name = "firstName") String firstName){
		return ResponseEntity.ok(customerService.getCustomerByFirstName(firstName));
	}
	
	@GetMapping("/lastname")
	public ResponseEntity<List<Customer>> findByLastNameIgnoreCaseContaining(@RequestParam (name = "lastName") String lastName){
		return ResponseEntity.ok(customerService.getCustomerByLastName(lastName));
	}
	
	
	// 2. Create Customer
	@PostMapping("/")
	public ResponseEntity<String> createCustomer(@Valid @RequestBody Customer customer){
		this.customerService.createCustomer(customer);
		return new ResponseEntity<String>("New Customer created", HttpStatus.CREATED);
	}
}

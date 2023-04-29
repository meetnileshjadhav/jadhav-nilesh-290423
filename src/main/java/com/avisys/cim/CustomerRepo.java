package com.avisys.cim;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepo extends JpaRepository<Customer, Long>{

	Optional<Customer> findByMobileNumber(String mobileNumber);
	
	Optional<Customer> findByFirstNameIgnoreCaseContaining(String firstName);
	
	List<Customer> findByLastNameIgnoreCaseContaining(String lastName);
}

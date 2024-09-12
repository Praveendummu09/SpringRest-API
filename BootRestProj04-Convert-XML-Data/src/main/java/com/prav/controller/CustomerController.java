package com.prav.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prav.model.Customer;



@RequestMapping("/customer-api")
@RestController
public class CustomerController {
	
	@GetMapping("/report")
	public ResponseEntity<Customer> showData()
	{
		return new ResponseEntity<Customer>
		(new Customer(1, "Praveen", 1500F, new String[] {"Mobile","Biscuts","Shirts"}),HttpStatus.OK);
	}
	
	@GetMapping("/report1")
	public Customer showData1()
	{
		
		return new Customer(2, "Praveen", 1500F, new String[] {"Mobile","Biscuts","Shirts"});
	}
	

}

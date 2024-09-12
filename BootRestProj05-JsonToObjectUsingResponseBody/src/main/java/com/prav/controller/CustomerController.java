package com.prav.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prav.model.Customer;



@RequestMapping("/customer-api")
@RestController
public class CustomerController {
	//Return Content as String format
	@PostMapping("/save")
	public ResponseEntity<String> data(@RequestBody Customer cust)
	{
		return new ResponseEntity<String>(cust.toString(),HttpStatus.OK);
	}
	
	
	//Return content as JSON content
	@PostMapping("/save1")
	public ResponseEntity<Customer> jsonContent(@RequestBody Customer cust)
	{
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	

}

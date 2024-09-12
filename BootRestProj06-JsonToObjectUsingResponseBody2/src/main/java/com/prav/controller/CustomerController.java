package com.prav.controller;



import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.prav.model.Employee;



@RequestMapping("/employee-api")
@RestController
public class CustomerController {
	//Return Content as String format
	@PostMapping("/save")
	public ResponseEntity<String> data(@RequestBody Employee emp)
	{
		return new ResponseEntity<String>(emp.toString(),HttpStatus.OK);
	}
	
	
	//Return content as JSON content
	@PostMapping("/save1")
	public ResponseEntity<Employee> jsonContent(@RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	

}

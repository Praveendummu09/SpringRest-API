package com.prav.controller;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message-api")
public class WishMessageProvider {

	@GetMapping("/wish")
	public ResponseEntity<String> showMessage()
	{
		LocalDateTime ldt=LocalDateTime.now();//its takes current values
		int hour=ldt.getHour();
		String msg;
		if(hour<12)
			msg="Good Morning";
		else if(hour>=12 && hour<16)
			msg="Good Afternoon";
		else if(hour>=16 && hour<20)
			msg="Good Evening";
		else
				msg="Good Night";
		ResponseEntity<String> entity=new ResponseEntity<String>( msg,HttpStatus.OK);
		return entity;
		
	}
}

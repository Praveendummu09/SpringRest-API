package com.prav.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerOperationController {

	@GetMapping("/report")
	public String reportData(@RequestParam("cno") Integer no, @RequestParam(required = false, defaultValue = "King") String cname)
	{
		return no+"   "+cname;
		// url :: http://localhost:8080/BootRestProj07-RequestParam/report?cno=120&cname=raja
	}
	@PostMapping("/report")
	public ResponseEntity<String> reportData1(@RequestParam Integer cno, @RequestParam String cname)
	{
		System.out.println(cno+"....."+cname);
		return new ResponseEntity<String>(cno+"______"+cname,HttpStatus.OK);
	}
}

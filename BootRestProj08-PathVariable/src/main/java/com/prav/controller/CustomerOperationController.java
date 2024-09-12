package com.prav.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerOperationController {

	@GetMapping("/save/{cno}/{cname}")
	public ResponseEntity<String> dataReport(@PathVariable(name ="cno", required = false) Integer no, @PathVariable(required = false) String cname)
	{
		return new ResponseEntity<String>(no+"..............."+cname,HttpStatus.OK);
	}
	
	
	//Request path satic level matching and prioritized
	@GetMapping("/report/cno/cname")
	public String ope1(@PathVariable(name ="cno", required = false) Integer no, @PathVariable(required = false) String cname)
	{
	    return "from FetchData1";
	}
	@GetMapping("/report/{cno}/cname")
	public String ope2(@PathVariable(name ="cno", required = false) Integer no, @PathVariable(required = false) String cname)
	{
	    return "from FetchData2";
	}
	@GetMapping("/report/cno/{cname}")
	public String ope3(@PathVariable(name ="cno", required = false) Integer no, @PathVariable(required = false) String cname)
	{
	    return "from FetchData3";
	}
	@GetMapping("/report/{cno}/{cname}")
	public String ope4(@PathVariable(name ="cno", required = false) Integer no, @PathVariable(required = false) String cname)
	{
	    return "from FetchData4";
	}
	
	@GetMapping(value = {"/save1/{cno}/{cname}","/save1/{cno}"})
	public String ope4(@PathVariable(name = "cno")String no,@PathVariable(name = "cname",required = false )String name)
	{
	    return "gives"+"\t"+no+"\t"+name;
	}
}

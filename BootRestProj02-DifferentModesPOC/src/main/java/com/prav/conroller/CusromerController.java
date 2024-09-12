package com.prav.conroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customer-api")
public class CusromerController {
	
	@GetMapping("/report")
	public ResponseEntity<String> getOperation(){
		return new ResponseEntity<String>("From GetShow Reports ",HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> postOperation(){
		return new ResponseEntity<String>("From Post-Register Report ",HttpStatus.OK);
	}

	@PutMapping("/edit")
	public ResponseEntity<String> putOperation(){
		return new ResponseEntity<String>("From Editin using put Reports ",HttpStatus.OK);
	}
	@PatchMapping("/pedit")
	public ResponseEntity<String> patchOperation(){
		return new ResponseEntity<String>("From Patch edit Reports ",HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteOperation(){
		return new ResponseEntity<String>("From Delete Reports ",HttpStatus.OK);
	}
}

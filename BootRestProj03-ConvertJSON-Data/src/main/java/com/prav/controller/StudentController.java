package com.prav.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prav.model.School;
import com.prav.model.Student;

@RestController
@RequestMapping("/student-api")
public class StudentController {
	
	@RequestMapping("/report")
	public ResponseEntity<Student> showReport()
	{
		//Student stud=new Student(1, "Ravi", "CSE");
		Student stud=new Student(1, "Raju", "CSE", new String[] {"DSA","Crypto Graphy","Java", "CN","ADS"},
				List.of("Blue","Red"), Set.of(705658955L,55655566L), 
				Map.of("Adhar",15424,"RollNo",4554554), new School(12, "ZPH School", "Mamidipalli"));
		return new ResponseEntity<Student>(stud,HttpStatus.OK);
	}
	
	@RequestMapping("/reports")
	public ResponseEntity<List<Student>> showReports(){
		List<Student> list=Arrays.asList(new Student(12,"Chandu", "CSE"),
				new Student(13,"Rekha","EEE"),
				new Student(14, "Loki", "CIVIL"));
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}

}

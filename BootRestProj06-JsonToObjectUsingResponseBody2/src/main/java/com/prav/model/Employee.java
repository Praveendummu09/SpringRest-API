package com.prav.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.Data;


@Data
public class Employee {
	
	private Integer empId;
	private String ename;
	private Float sal;
	private List<Company> companyList;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime joining;
	private List<Map<String,Long>> govID;
	
	

}

package com.prav.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Student {
	
	@NonNull
	private Integer studId;
	@NonNull
	private String name;
	@NonNull
	private String desg;
	private String[] subj;
	private List<String> favcolor;
	private Set<Long> phone;
	private Map<String, Object> ids;
	// HAS-A relation
	private School school;
	
	

}

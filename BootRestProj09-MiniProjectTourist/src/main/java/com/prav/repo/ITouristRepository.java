package com.prav.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prav.entity.Tourister;

import jakarta.transaction.Transactional;

public interface ITouristRepository extends JpaRepository<Tourister, Integer>{
	
	@Query("from Tourister where name=:name")
	public List<Tourister> getByName(@Param("name") String name);
	
	
	//Get tourister by city names
	@Query("from Tourister where city in(:city1,:city2) order by name asc")
	public List<Tourister> findTouristByName(String city1,String city2);
	
	@Query("delete from Tourister where budget>=:start and budget<=:end")
	@Modifying
	@Transactional
	public int deletebyRange(double start,double end);
	
	
	

}

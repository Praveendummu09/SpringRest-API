package com.prav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prav.entity.Tourister;
import com.prav.service.ITouristerService;

@RestController
@RequestMapping("/tourist")
public class ToursitController {
	
	@Autowired
	private ITouristerService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Tourister tourist)
	{
		String str=service.registerTouriste(tourist);
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	
	@GetMapping("/total")
	public ResponseEntity<?> data()
	{
		try {
		List<Tourister> list=service.fetchAll();
		return new ResponseEntity<List<Tourister>> (list,HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<String>("Problem to fetching Tourists",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/single/{tno}")
	public ResponseEntity<?> tourist(@PathVariable("tno") Integer tno)
	{
		try {
		Tourister tour=service.findingByID(tno);
		return new ResponseEntity<Tourister> (tour,HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Update Tourist
	@PutMapping("/update")
	public ResponseEntity<String> UpdateTourist(@RequestBody Tourister tourist)
	{
		try {
		String str=service.updateTourist(tourist);
		return new ResponseEntity<String>(str,HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/name/{name}")
	public ResponseEntity<?> getByName(@PathVariable("name") String tname)
	{
		try {
		List<Tourister> list=service.selectByName(tname);
		return new ResponseEntity<List<Tourister>> (list,HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//Tourists get by cities
	@GetMapping("/bycities/{city1}/{city2}")
	public ResponseEntity<?> getByCity(@PathVariable("city1") String city1,@PathVariable("city2") String city2)
	{
		try {
		List<Tourister> list=service.selectByCities(city1, city2);
		return new ResponseEntity<List<Tourister>> (list,HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Tourists get by cities
	@GetMapping("/budget/{id}/{perc}")
	public ResponseEntity<?> partialUpdate(@PathVariable("id") Integer id,@PathVariable("perc") Float perc)
		{
			try {
			String str=service.updateTouristBudgetById(id, perc);
			return new ResponseEntity<String> (str,HttpStatus.OK);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	//Delete the tourist
	@GetMapping("/delete/{id}")
	public ResponseEntity<?> touristDelete(@PathVariable("id") Integer id)
		{
			try {
			String str=service.touristDeleteById(id);
			return new ResponseEntity<String> (str,HttpStatus.OK);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	@GetMapping("/deletebyrange/{start}/{end}")
	public ResponseEntity<?> touristDelete(@PathVariable("start") double start,@PathVariable("end") double end)
		{
			try {
			String str=service.deleteByBudgetRange(start, end);
			return new ResponseEntity<String> (str,HttpStatus.OK);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	

}

package com.prav.service;

import java.util.List;

import com.prav.entity.Tourister;

public interface ITouristerService  {

	public String registerTouriste(Tourister tourister);
	public List<Tourister> fetchAll();
	public Tourister findingByID(Integer tid)throws TouristerNotFoundException;
	public String updateTourist(Tourister tourister)throws TouristerNotFoundException;
	public List<Tourister> selectByName(String tname);
	public List<Tourister> selectByCities(String city1,String city2);
	public String updateTouristBudgetById(Integer tid,Float prec) throws TouristerNotFoundException;
	public String touristDeleteById(Integer id) throws TouristerNotFoundException;
	public String deleteByBudgetRange(double start,double end);
}

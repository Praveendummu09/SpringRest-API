package com.prav.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prav.entity.Tourister;
import com.prav.repo.ITouristRepository;

@Service("touristService")
public class TouristerServiceCLass implements ITouristerService {

	@Autowired
	private ITouristRepository touristrepo;
	@Override
	public String registerTouriste(Tourister tourister) {
		Integer id=touristrepo.save(tourister).getTid();
		return "Tourist Saved with Id :" +id;
	}
	
	//Fetching Tourists List
	@Override
	public List<Tourister> fetchAll() {
		List<Tourister> list=touristrepo.findAll();
		list.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));

		return list;
	}

	@Override
	public Tourister findingByID(Integer tid) throws TouristerNotFoundException {
		// TODO Auto-generated method stub
		return touristrepo.findById(tid)
				.orElseThrow(()->new TouristerNotFoundException(tid+" Id tourist not found"));
	}

	@Override
	public String updateTourist(Tourister tourister) throws TouristerNotFoundException {
		Optional<Tourister> tour=touristrepo.findById(tourister.getTid());
		if(tour.isPresent()) {
			touristrepo.save(tourister);
			return tourister.getTid()+" Tourist Updated";
			
		}
		else
		{
			throw new TouristerNotFoundException(tourister.getTid()+" Id tourist not found");
		}
		
	}

	@Override
	public List<Tourister> selectByName(String name) {
		// TODO Auto-generated method stub
		return touristrepo.getByName(name);
	}

	@Override
	public List<Tourister> selectByCities(String city1, String city2) {
	
		return touristrepo.findTouristByName(city1, city2);
	}

	//Pratial Updation
	@Override
	public String updateTouristBudgetById(Integer tid, Float perc) throws TouristerNotFoundException {
		// TODO Auto-generated method stub
		Optional<Tourister> optional=touristrepo.findById(tid);
		if(optional.isPresent())
		{
			Tourister tour=optional.get();
			double budget=tour.getBudget();
			double newBudget=budget+(budget+perc/100);
			tour.setBudget(newBudget);
			return "Tourister with :"+touristrepo.save(tour).getTid()+" new Budget updated ....";
			
		}
		else
			throw new TouristerNotFoundException(tid+" id tourist not found");
	}

	@Override
	public String touristDeleteById(Integer id) throws TouristerNotFoundException {
		Optional<Tourister> optional=touristrepo.findById(id);
		if(optional.isPresent())
		{
			touristrepo.deleteById(id);
			return id+" id employee deleted";
		}
		else
			throw new TouristerNotFoundException(id+" id tourist not found");
	}

	@Override
	public String deleteByBudgetRange(double start, double end) {
		int count=touristrepo.deletebyRange(start, end);
		return count==0?"no tourist found":count+" tourisers are deleted";
	}
	

	

	
}

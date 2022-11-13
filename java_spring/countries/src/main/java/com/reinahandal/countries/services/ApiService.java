package com.reinahandal.countries.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinahandal.countries.repositories.CountryRepository;

@Service
public class ApiService {

	@Autowired
	CountryRepository countryRepo;
	
	public List<Object[]> firstQuery(){
		return countryRepo.firstQuery();
	}
	public List<Object[]> secondQuery(){
		return countryRepo.secondQuery();
	}
	
	public List<Object[]> thirdQuery(){
    	return countryRepo.thirdQuery();
    }
	public List<Object[]> fourthQuery(){
    	return countryRepo.fourthQuery();
    }
	public List<Object[]> fifthQuery(){
    	return countryRepo.fifthQuery();
    }
	public List<Object[]> sixthQuery(){
    	return countryRepo.sixthQuery();
    }
	public List<Object[]> seventhQuery(){
    	return countryRepo.seventhQuery();
    }
	public List<Object[]> eighthQuery(){
    	return countryRepo.eighthQuery();
    }
	
}

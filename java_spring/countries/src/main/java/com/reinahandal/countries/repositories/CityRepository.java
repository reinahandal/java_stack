package com.reinahandal.countries.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reinahandal.countries.models.City;

public interface CityRepository extends CrudRepository<City, Integer> {
	
}

package com.reinahandal.countries.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reinahandal.countries.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Integer> {
	
}

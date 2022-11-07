package com.reinahandal.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reinahandal.dojoandninjas.models.Dojo;
import com.reinahandal.dojoandninjas.repositories.DojoRepository;


@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository=dojoRepository;
	}
	// returns all dojos
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	// creates dojo
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	// retrieves dojo
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	// updates dojo
	public Dojo updateDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
    // deletes dojo
    public void deleteDojo(Long id) {
    	dojoRepository.deleteById(id);
    }
}

package com.reinahandal.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reinahandal.dojoandninjas.models.Ninja;
import com.reinahandal.dojoandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository=ninjaRepository;
	}
	// returns all ninjas
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	// creates ninja
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	// retrieves ninja
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	// updates ninja
	public Ninja updateNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
    // deletes ninja
    public void deleteNinja(Long id) {
    	ninjaRepository.deleteById(id);
    }
}

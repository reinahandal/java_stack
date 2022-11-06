package com.reinahandal.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reinahandal.languages.models.Language;
import com.reinahandal.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository=languageRepository;
	}
	
	// returns all languages
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	// creates language
	public Language createLanguage(Language lang) {
		return languageRepository.save(lang);
	}
	// retrieves language
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	// updates language
	public Language updateLanguage(Language lang) {
		return languageRepository.save(lang);
	}
    // deletes language
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);
    }
}

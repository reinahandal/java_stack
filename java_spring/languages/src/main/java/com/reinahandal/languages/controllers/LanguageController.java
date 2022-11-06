package com.reinahandal.languages.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reinahandal.languages.models.Language;
import com.reinahandal.languages.services.LanguageService;


@Controller
@RequestMapping("/languages")
public class LanguageController {
	@Autowired
	LanguageService languageService;
	
	// method that renders page with table with all languages and form to add a language
	@GetMapping("")
	public String index(@ModelAttribute("language") Language language, Model model) {
		model.addAttribute("languages", languageService.allLanguages());
		return "index.jsp";
	}
	
	
	// method that creates new language
	@PostMapping("")
	public String createLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("languages", languageService.allLanguages());
			return "index.jsp";
		}
		else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	// method that renders a page that shows details of a given language
	@GetMapping("/{id}")
	public String showLanguage(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "show.jsp";
	}
	
    // method that renders a page with a form to edit language
    @GetMapping("/{id}/edit")
    public String editLanguage(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
        return "edit.jsp";
    }
    
	
    // method that updates a given language
    @PutMapping("/{id}")
    public String updateLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
    
    // method that deletes a given language
    @DeleteMapping("/{id}")
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
}

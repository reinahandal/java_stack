package com.reinahandal.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class MainController {

	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submit(
		@RequestParam(value="number") int number,
		@RequestParam(value="city") String city,
		@RequestParam(value="person") String person,
		@RequestParam(value="hobby") String hobby,
		@RequestParam(value="creature") String creature,
		@RequestParam(value="comment") String comment,
		HttpSession session) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("creature", creature);
		session.setAttribute("comment", comment);
		return "redirect:/omikuji/show";
	}
	
	@RequestMapping("/show")
	public String show() {
		return "show.jsp";
	}

}

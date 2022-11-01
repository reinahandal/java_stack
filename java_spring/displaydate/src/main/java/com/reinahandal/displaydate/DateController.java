package com.reinahandal.displaydate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		java.util.Date date = new java.util.Date();
		model.addAttribute("date",date);
		return "displayDate.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		java.util.Date date = new java.util.Date();
		model.addAttribute("date",date);
		return "displayTime.jsp";
	}
}

package com.reinahandal.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false, defaultValue="Human") String firstName, @RequestParam(value="last_name", required=false, defaultValue="") String lastName) {
			return "Hello " + firstName + " " + lastName;
	}
}
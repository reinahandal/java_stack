package com.reinahandal.countries.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reinahandal.countries.services.ApiService;


@RestController
public class WorldController {
	@Autowired
	ApiService apiService;
	
	@RequestMapping("/q1")
	public List<Object[]> index() {
		List<Object[]> table = apiService.firstQuery();
		return table;
	}
	@RequestMapping("/q2")
	public List<Object[]> index2() {
		List<Object[]> table = apiService.secondQuery();
		return table;
	}
	@RequestMapping("/q3")
	public List<Object[]> index3() {
		List<Object[]> table = apiService.thirdQuery();
		return table;
	}
	@RequestMapping("/q4")
	public List<Object[]> index4() {
		List<Object[]> table = apiService.fourthQuery();
		return table;
	}
	@RequestMapping("/q5")
	public List<Object[]> index5() {
		List<Object[]> table = apiService.fifthQuery();
		return table;
	}
	@RequestMapping("/q6")
	public List<Object[]> index6() {
		List<Object[]> table = apiService.sixthQuery();
		return table;
	}
	@RequestMapping("/q7")
	public List<Object[]> index7() {
		List<Object[]> table = apiService.seventhQuery();
		return table;
	}
	@RequestMapping("/q8")
	public List<Object[]> index8() {
		List<Object[]> table = apiService.eighthQuery();
		return table;
	}
	
}

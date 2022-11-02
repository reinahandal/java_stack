package com.reinahandal.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping("/gold")
	public String index(HttpSession session) {
		if (session.getAttribute("counter")== null && session.getAttribute("allActivities") == null) {
			session.setAttribute("counter", 0);
			ArrayList<ArrayList<String>> allActivities = new ArrayList<ArrayList<String>>();
			session.setAttribute("allActivities", allActivities);
		}
		return "index.jsp";
	}
	@PostMapping("/gold/find")
	public String find(
		@RequestParam(value="activity") String activity,
		HttpSession session) {
		
		Integer randomNum=0;
		String message="";
		String color="";
		ArrayList<String> currentActivity = new ArrayList<String>();
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd yyyy, hh:mm a");
		Random random = new Random();
		
		if (activity.equals("farm")) {
			randomNum = random.nextInt(11) + 10; // 10 to 20
			message = "You entered a "+ activity + " and earned " + randomNum + " gold. (" + sdf.format(date) + ")";
			color = "green";
			currentActivity.add(message);
			currentActivity.add(color);
			
		}
		else if (activity.equals("cave")) {
			randomNum = random.nextInt(6) + 5; // 5 to 10
			message = "You entered a "+ activity + " and earned " + randomNum + " gold. (" + sdf.format(date) + ")";
			color = "green";
			currentActivity.add(message);
			currentActivity.add(color);
			
		}
		else if (activity.equals("house")) {
			randomNum = random.nextInt(4) + 2; // 2 to 5
			message = "You entered a "+ activity + " and earned " + randomNum + " gold. (" + sdf.format(date) + ")";
			color = "green";
			currentActivity.add(message);
			currentActivity.add(color);

		}
		else if (activity.equals("quest")) {
			randomNum = random.nextInt(101) - 50; // -50 to 50
			if(randomNum > 0) {
				message = "You entered a "+ activity + " and earned " + randomNum + " gold. (" + sdf.format(date) + ")";
				color = "green";
				currentActivity.add(message);
				currentActivity.add(color);

			}
			else {
				message = "You entered a "+ activity + " and lost " + randomNum*-1 + " gold. (" + sdf.format(date) + ")";
				color = "red";
				currentActivity.add(message);
				currentActivity.add(color);
			}
		}
		Integer newCount = (Integer) session.getAttribute("counter");
		newCount+=randomNum;
		session.setAttribute("counter", newCount);
		
		@SuppressWarnings("unchecked")
		ArrayList<ArrayList<String>> allActivities = (ArrayList<ArrayList<String>>) session.getAttribute("allActivities");
		allActivities.add(0, currentActivity);
		
		return "redirect:/gold";
	}
	
	@RequestMapping("/destroy")
	public String destroy(HttpSession session) {
		if (session.getAttribute("counter")!= null){
			session.removeAttribute("counter");
			session.removeAttribute("allActivities");
		}
		return "redirect:/gold";
	}
}

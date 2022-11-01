package com.reinahandal.counter;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count")== null) {
			session.setAttribute("count", 1);	
		}
		else {
			Integer newCount = (Integer) session.getAttribute("count");
			newCount+=1;
			session.setAttribute("count", newCount);
		}
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		return "counter.jsp";
	}
	@RequestMapping("/destroy")
	public String destroy(HttpSession session) {
		if (session.getAttribute("count")!= null){
				session.removeAttribute("count");
		}
		return "counter.jsp";
	}
	
}

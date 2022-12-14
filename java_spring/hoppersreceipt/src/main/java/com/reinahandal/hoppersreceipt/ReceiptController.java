package com.reinahandal.hoppersreceipt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReceiptController {
	@RequestMapping("/")
	public String index(Model model) {
        String name = "Valentina Tereshkova";
        String itemName = "Copper wire";
        double price = 5.25;
        String description = "Metal strips, also an illustration of nanoseconds.";
        String vendor = "The Sputnik";
        
        model.addAttribute("name", name);
        model.addAttribute("item", itemName);
        model.addAttribute("price", price);
        model.addAttribute("desc", description);
        model.addAttribute("vendor", vendor);
        
		return "index.jsp";
	}
}

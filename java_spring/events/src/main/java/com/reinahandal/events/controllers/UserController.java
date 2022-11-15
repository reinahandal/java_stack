package com.reinahandal.events.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.reinahandal.events.models.LoginUser;
import com.reinahandal.events.models.State;
import com.reinahandal.events.models.User;
import com.reinahandal.events.services.UserService;

@Controller
public class UserController {
    
     @Autowired
     private UserService userService;
    
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
    	if (session.getAttribute("userId") != null) {
    		return "redirect:/events";
    	} else {
    		// Bind empty User and LoginUser objects to the JSP
    		// to capture the form input
    		model.addAttribute("newUser", new User());
    		model.addAttribute("newLogin", new LoginUser());
    		model.addAttribute("states", State.values());
    		return "loginreg.jsp";		
    	}
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        // call a register method in the service 
        // to do some extra validations and create a new user
    	userService.register(newUser, result);
        
        if(result.hasErrors()) {
            // send in the empty LoginUser before 
            // re-rendering the page
            model.addAttribute("newLogin", new LoginUser());
            return "loginreg.jsp";
        }
        else {
        	// no errors
        	// store the user id in session (log them in)
        	session.setAttribute("userId", newUser.getId());
    		// find user instance by id
    		User thisUser =	userService.findUserById(newUser.getId());
    		// add user to session
    		session.setAttribute("thisUser", thisUser);
        	return "redirect:/events";
        }

    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // implements login method in userService
    	// which returns user instance if there are no errors
        User user = userService.login(newLogin, result);
         
        if(result.hasErrors()) {
        	//send in the empty newUser before re-rendering
            model.addAttribute("newUser", new User());
            return "loginreg.jsp";
        }
        else {
        	// no errors
        	// stores user id in session (they are now logged in)
        	session.setAttribute("userId", user.getId());
    		// find user instance by id
    		User thisUser =	userService.findUserById(user.getId());
    		// add user to session
    		session.setAttribute("thisUser", thisUser);
        }
        return "redirect:/events";
    }

    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
}

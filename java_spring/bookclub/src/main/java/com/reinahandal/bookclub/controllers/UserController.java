package com.reinahandal.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.reinahandal.bookclub.models.LoginUser;
import com.reinahandal.bookclub.models.User;
import com.reinahandal.bookclub.services.UserService;

@Controller
public class UserController {
    
     @Autowired
     private UserService userService;
    
    @GetMapping("/")
    public String index(Model model) {
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "loginreg.jsp";
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
        	return "redirect:/books";
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
        }
        return "redirect:/books";
    }

    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
}

package com.reinahandal.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reinahandal.bookclub.models.Book;
import com.reinahandal.bookclub.services.BookService;
import com.reinahandal.bookclub.services.UserService;

@Controller
@RequestMapping("/bookmarket")
public class BookBrokerController {
	
	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;
	
	@GetMapping("")
	public String broker(HttpSession session, Model model) {
    	if(session.getAttribute("userId") != null) {
    		model.addAttribute("unborrowedBooks", bookService.unborrowed());
    		Long loggedUserId = (Long) session.getAttribute("userId");
    		List<Book> booksIBorrowed = bookService.borrowedByMe(loggedUserId);
    		model.addAttribute("booksIBorrowed", booksIBorrowed);
    		return "bookbroker.jsp";
    	} else {
    		return "redirect:/";
    	}
	}
	
	@GetMapping("/borrow/{id}")
	public String borrow(@PathVariable("id") Long bookId, HttpSession session) {
    	if(session.getAttribute("userId") != null) {
    		Book bookToBorrow = bookService.findBook(bookId);
    		Long borrowerId = (Long) session.getAttribute("userId");
    		bookService.borrowBook(bookToBorrow, borrowerId);
    		return "redirect:/bookmarket";
    	} else {
    		return "redirect:/";
    	}

	}
	
	@GetMapping("/return/{id}")
	public String returnBook(@PathVariable("id") Long bookId, HttpSession session) {
	   	if (session.getAttribute("userId") != null) {
	   		if((Long) session.getAttribute("userId") == bookService.findBook(bookId).getBorrower().getId()) {
	   			bookService.returnBook(bookId);
	   			return "redirect:/bookmarket";
	   		} else {
	   			return "redirect:/bookmarket";
	   		}
	   	} else {
	   		return "redirect:/";   		
	   	}
	}
	
}

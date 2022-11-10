package com.reinahandal.bookclub.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.reinahandal.bookclub.models.Book;
import com.reinahandal.bookclub.services.BookService;
import com.reinahandal.bookclub.services.UserService;



@Controller
public class BookController {
	
	// using dependency injection to have access to service in one line
	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;	
    
    @GetMapping("/books")
    public String index(HttpSession session, Model model) {
    	if(session.getAttribute("userId") != null) {
    		// render home page
    		ArrayList<Book> books = bookService.allBooks();
    		model.addAttribute("books", books);
    		return "index.jsp";
    	}
    	else {
    		// if user not in session (not logged in)
    		return "redirect:/";
    	}
    }
    
	// renders a form to add a new book
    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book, HttpSession session) {
    	if(session.getAttribute("userId") != null) {
    		return "new.jsp";		
    	} else {
    		return "redirect:/";
    	}
    }
    
    @PostMapping("/createbook")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
        	Long loggedUserId = (Long) session.getAttribute("userId");
            bookService.createBook(book, loggedUserId);
            return "redirect:/books";
        }
    }
	// shows details of a given book
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable("id") Long id, Model model, HttpSession session) {
    	if(session.getAttribute("userId") != null) {
    		Book book = bookService.findBook(id);
    		if(book == null) {
    			return "redirect:/books";
    		} else {
    			model.addAttribute("book", book);	
    		}
    		return "show.jsp";
    	} else {
    		return "redirect:/";
    	}
	}
	
    // renders a page with an edit form -- MUST BE THE USER WHO ADDED IT 
    @GetMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
    	if (session.getAttribute("userId") != null) {
    		if((Long) session.getAttribute("userId") == bookService.findBook(id).getUser().getId()) {
    			Book book = bookService.findBook(id);
    			model.addAttribute("book", book);
    			return "edit.jsp";
    		} else {
    			return "redirect:/books";
    		}
    	} else {
    		return "redirect:/";
    	}
    }
    // updates book -- MUST BE THE USER WHO ADDED IT 
    @PutMapping("/books/{id}")
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
    	if (session.getAttribute("userId") != null) {
    		if((Long) session.getAttribute("userId") == bookService.findBook(id).getUser().getId()) {
    			if (result.hasErrors()) {
    				return "edit.jsp";
    			} else {
    				Long loggedUserId = (Long) session.getAttribute("userId");
    				bookService.updateBook(book, loggedUserId);
    				return "redirect:/books/"+id;
    			}		
    		} else {
    			return "redirect:/books";
    		}
    	} else {
    		return "redirect:/";
    	}
    }

    // deletes book -- MUST BE THE USER WHO ADDED IT
    @DeleteMapping("/books/{id}")
    public String destroy(@PathVariable("id") Long id, HttpSession session) {
    	if((Long) session.getAttribute("userId") == bookService.findBook(id).getUser().getId()) {
    		bookService.deleteBook(id);
    		return "redirect:/books"; 		
    	} else {
    		return "redirect:/books/"+id;
    	}
    }
}

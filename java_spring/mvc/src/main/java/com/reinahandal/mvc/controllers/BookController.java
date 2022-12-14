package com.reinahandal.mvc.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.reinahandal.mvc.models.Book;
import com.reinahandal.mvc.services.BookService;


@Controller
public class BookController {
	
	// using dependency injection to have access to service in one line
	@Autowired
	BookService bookService;
	
	@GetMapping("/books/{bookId}")
	public String showBook(@PathVariable("bookId") Long bookId, Model model) {
		
		Book book = bookService.findBook(bookId);
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
	
	@GetMapping("/books")
	public String index(Model model) {
		ArrayList<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		
		return "index.jsp";
	}
}

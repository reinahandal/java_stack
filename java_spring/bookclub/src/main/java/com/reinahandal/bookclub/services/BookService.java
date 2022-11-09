package com.reinahandal.bookclub.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinahandal.bookclub.models.Book;
import com.reinahandal.bookclub.models.User;
import com.reinahandal.bookclub.repositories.BookRepository;
import com.reinahandal.bookclub.repositories.UserRepository;



@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Autowired
    private UserRepository userRepo;
    
    // returns all the books
    public ArrayList<Book> allBooks() {
        return (ArrayList<Book>) bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b, Long id) {
    	Optional<User> u = userRepo.findById(id);
    	if(u.isPresent()) {
    		User loggedUser = u.get();
    		b.setUser(loggedUser);
    		return bookRepository.save(b);	
    	} else {
    		return null;
    	}
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

    // updates a book 
    public Book updateBook(Book b, Long id) {
    	Optional<User> u = userRepo.findById(id);
    	if(u.isPresent()) {
    		User loggedUser = u.get();
    		b.setUser(loggedUser);
    		return bookRepository.save(b);	
    	} else {
    		return null;
    	}
    }
    
    // deletes a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}

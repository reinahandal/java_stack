package com.reinahandal.bookclub.services;

import java.util.ArrayList;
import java.util.List;
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

    // updates a book while keeping the borrower
    public Book updateBook(Book b, Long id) {
    	Optional<Book> opBook = bookRepository.findById(b.getId());
    	User borrower = opBook.get().getBorrower();
    		if(borrower!=null) {
    			b.setBorrower(borrower);
        		return bookRepository.save(b);
    		} else {
    			return bookRepository.save(b);				
    		}
    }
    
    // borrows a book
    public Book borrowBook(Book b, Long id) {
      	Optional<User> u = userRepo.findById(id);
    	if(u.isPresent()) {
    		User borrower = u.get();
    		b.setBorrower(borrower);
    		return bookRepository.save(b);	
    	} else {
    		return null;
    	}
    }
    
    // deletes a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
    
    // return unborrowed books
    public List<Book> unborrowed(){
    	return bookRepository.findAllByBorrowerIsNull();
    }
    
    // return books the logged in user borrowed
    public List<Book> borrowedByMe(Long id){
    	return bookRepository.findAllByBorrowerId(id);
    }
    
    // (unborrows) book
    public Book returnBook(Long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isPresent()) {
            Book b = optionalBook.get();
            b.setBorrower(null);
    		return bookRepository.save(b);
        } else {
            return null;
        }   	
    }
}

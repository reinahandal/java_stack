package com.reinahandal.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reinahandal.bookclub.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    // retrieves all the books from the database
    List<Book> findAll();

    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);
}

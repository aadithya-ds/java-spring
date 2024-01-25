package com.example.validator.service;

import com.example.validator.dto.BookDto;
import com.example.validator.entity.Book;
import com.example.validator.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    public Book getById(int id) {
        return bookRepository.findById(id).orElse(null);
    }


    public String addBook(BookDto bookData) {


            Book book = new Book(bookData);
            Book savedbook = bookRepository.save(book);

            return savedbook.toString();

    }
}

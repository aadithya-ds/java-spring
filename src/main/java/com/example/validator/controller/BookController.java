package com.example.validator.controller;


import com.example.validator.GlobalExceptionHandler;
import com.example.validator.dto.BookDto;
import com.example.validator.entity.Book;
import com.example.validator.repository.BookRepository;
import com.example.validator.service.BookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

@RequestMapping("/api/v1/books")
@Slf4j
public class BookController {


    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;


    private static final Logger logger = LoggerFactory.getLogger(BookController.class);


    @PostMapping("/")
    public String addBook( @Valid @RequestBody BookDto bookData) throws GlobalExceptionHandler {
        return bookService.addBook(bookData);
    }


    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        logger.info("Fetching all books");
        return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book = bookService.getById(id);

        if (book != null) {
            logger.info("Fetching book with id: {}", id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            logger.warn("Book with id {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

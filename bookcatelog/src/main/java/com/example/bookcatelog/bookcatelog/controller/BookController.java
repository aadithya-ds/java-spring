package com.example.bookcatelog.bookcatelog.controller;

import com.example.bookcatelog.bookcatelog.entity.Book;
import com.example.bookcatelog.bookcatelog.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBook() {
        return new  ResponseEntity<>(bookService.getBook(),HttpStatus.OK);
    }
}

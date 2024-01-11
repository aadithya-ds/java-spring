package com.example.pagination.Pagination.Controller;


import com.example.pagination.Pagination.Entity.Book;
import com.example.pagination.Pagination.Services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/bookstore")
public class BookController {


    @Autowired
    private BookServices bookServices;


    @GetMapping
    public Page<Book> getBooks(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
        return bookServices.getallbooks(page,size);
    }
}

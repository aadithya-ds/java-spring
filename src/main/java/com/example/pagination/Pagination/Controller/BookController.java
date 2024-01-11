package com.example.pagination.Pagination.Controller;


import com.example.pagination.Pagination.Entity.Book;
import com.example.pagination.Pagination.Services.BookServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/bookstore")
@Slf4j
public class BookController {


    @Autowired
    private BookServices bookServices;


    @GetMapping
    public Page<Book> getBooks(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
        return bookServices.getallbooks(page,size);
    }

    @GetMapping("/logs")
    public String getLog(){
        log.trace("This is a TRACE message");
        log.debug("This is a DEBUG message");
        log.info("This is an INFO message");
        log.warn("This is a WARN message");
        log.error("This is an ERROR message");

        return "Logger Exicuted";
    }
}

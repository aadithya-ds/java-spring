package com.example.bookcatelog.bookcatelog.services;


import com.example.bookcatelog.bookcatelog.BookcatelogApplication;
import com.example.bookcatelog.bookcatelog.entity.Book;
import com.example.bookcatelog.bookcatelog.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBook(){



        return bookRepository.findAll();

    }
}

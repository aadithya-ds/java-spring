package com.example.pagination.Pagination.Services;

import com.example.pagination.Pagination.Entity.Book;
import com.example.pagination.Pagination.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServices {

    @Autowired
    private BookRepo brepo;

    public Page<Book> getallbooks(int page,int size) {

        PageRequest pageRequest = PageRequest.of(page,size);
        return brepo.findAll(pageRequest);
    }
}

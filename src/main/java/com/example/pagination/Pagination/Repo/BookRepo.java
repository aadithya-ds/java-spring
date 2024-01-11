package com.example.pagination.Pagination.Repo;

import com.example.pagination.Pagination.Entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Integer> {
            Page<Book> findAll(Pageable pageable);
}

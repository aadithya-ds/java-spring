package com.example.bookcatelog.bookcatelog.repository;

import com.example.bookcatelog.bookcatelog.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

}

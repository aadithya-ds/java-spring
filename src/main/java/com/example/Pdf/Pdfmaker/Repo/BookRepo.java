package com.example.Pdf.Pdfmaker.Repo;

import com.example.Pdf.Pdfmaker.Entity.BookShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<BookShop,Integer> {

}

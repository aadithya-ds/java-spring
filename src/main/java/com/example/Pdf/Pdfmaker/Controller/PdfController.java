package com.example.Pdf.Pdfmaker.Controller;


import com.example.Pdf.Pdfmaker.Entity.BookShop;
import com.example.Pdf.Pdfmaker.Repo.BookRepo;
import com.example.Pdf.Pdfmaker.Service.PdfService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class PdfController {

    @Autowired
    private BookRepo entityRepository;

    @Autowired
    private PdfService pdfService;

    @GetMapping("/generate-pdf")
    public ResponseEntity<ByteArrayResource> generatePdf() throws DocumentException , IOException {
        List<BookShop> data = entityRepository.findAll(); // Fetch data from the database

        ByteArrayOutputStream bis = pdfService.generatePdf(data);

        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=example.pdf");
        headers.add("Content-Disposition", "attachment; filename=BookStore.pdf");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new ByteArrayResource(bis.toByteArray()));
    }
}

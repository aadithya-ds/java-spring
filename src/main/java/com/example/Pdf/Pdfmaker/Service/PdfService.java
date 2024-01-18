package com.example.Pdf.Pdfmaker.Service;

import com.example.Pdf.Pdfmaker.Entity.BookShop;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Header;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfService {

    public ByteArrayOutputStream generatePdf(List<BookShop> data) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, out);
        document.open();

        Paragraph p = new Paragraph("BookStore");
        p.setAlignment(Paragraph.ALIGN_CENTER);


        document.add(p);

        document.add(new Paragraph("Id     BookTitle"));

        for (BookShop entity : data) {
            // Use tab characters to separate the columns
            String line = entity.getId() + "     " + entity.getBookTitle() ;
            document.add(new Paragraph(line));
        }


        document.close();
        return out;
    }
}

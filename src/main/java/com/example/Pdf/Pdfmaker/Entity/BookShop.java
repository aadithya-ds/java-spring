package com.example.Pdf.Pdfmaker.Entity;


import jakarta.persistence.*;
import  lombok.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="books")

public class BookShop {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    private int id;
    @Column(name = "book_title")

    private String bookTitle;

    @Column(name = "author")
    private String author;

}

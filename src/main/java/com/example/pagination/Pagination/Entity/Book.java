package com.example.pagination.Pagination.Entity;


import com.example.pagination.Pagination.DTO.BookDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    private int id;
    @Column(name = "book_title")
    @NotEmpty(message = "BookTitle should not be Empty !")
    private String bookTitle;
    @NotEmpty(message = "Author field should not be Empty")
    @Column(name = "author")
    private String author;


    public Book(BookDTO bookDTO) {
        this.bookTitle = bookDTO.getBookTitle();
        this.author = bookDTO.getAuthor();
    }
}

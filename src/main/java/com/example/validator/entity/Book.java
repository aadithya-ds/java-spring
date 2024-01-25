package com.example.validator.entity;


import com.example.validator.dto.BookDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int bookId;


    @NotEmpty(message = "Author name should not be empty...")
    @Column(name = "author_name")
    private String authorName;

    @NotEmpty(message = "Title should not be empty...")
    @Column(name = "title")
    private String title;


    public Book(BookDto bookData) {
        authorName = bookData.getAuthorName();
        title = bookData.getTitle();
    }


}

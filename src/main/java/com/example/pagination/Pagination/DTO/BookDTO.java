package com.example.pagination.Pagination.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private int id;

    @NotBlank(message = "Book title must not be blank")
    private String bookTitle;

    @NotBlank(message = "Book author must not be blank")
    private String author;
}

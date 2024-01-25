package com.example.validator.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private int bookId;

    @NotBlank(message = "Author field must not be blank")
    private String authorName;

    @NotBlank(message = "Title field must not be blank")
    private String title;

}

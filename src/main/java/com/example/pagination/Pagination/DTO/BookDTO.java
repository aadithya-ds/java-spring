package com.example.pagination.Pagination.DTO;

import jakarta.persistence.Column;
import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private int id;

    private String bookTitle;

    private String author;
}

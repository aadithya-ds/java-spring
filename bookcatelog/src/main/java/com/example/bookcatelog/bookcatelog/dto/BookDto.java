package com.example.bookcatelog.bookcatelog.dto;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private String bookId;
    private String title;
    private String author;
}

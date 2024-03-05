package com.romansayapin.Librarybookmanagementservice.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookDto {
    String title;
    String author;
    String genre;
    int year;
}

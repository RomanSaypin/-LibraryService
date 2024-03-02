package com.romansayapin.Librarybookmanagementservice.controller;

import com.romansayapin.Librarybookmanagementservice.dto.BookDto;
import com.romansayapin.Librarybookmanagementservice.entity.Book;
import com.romansayapin.Librarybookmanagementservice.servise.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Tag(name = "Books Controller")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    private final ModelMapper modelMapper;

    @Operation(
            summary = "Добавляет новую книгу в базу"
    )
    @PostMapping
    public ResponseEntity<BookDto> addBook(@Valid @RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.OK).body(
                modelMapper.map(bookService.saveDataBase(book), BookDto.class)
        );
    }

    //
    @Operation(
            summary = "Возвращает список всех книг"
    )
    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(bookService.getListBook()
                        .stream()
                        .map(x -> modelMapper.map(x, BookDto.class))
                        .toList()
                );
    }

    //
    @Operation(
            summary = "Возвращает книгу по id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).
                body(modelMapper.map(bookService.getBook(id), BookDto.class));
    }

    //
    @Operation(
            summary = "Обновляет информацию о книге"
    )
    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBookInformation(book);
    }

    //
    @Operation(
            summary = "Удаляет книгу по id"
    )
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}

package com.romansayapin.Librarybookmanagementservice.controller;

import com.romansayapin.Librarybookmanagementservice.servise.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.romansayapin.Librarybookmanagementservice.entity.Book;

import java.util.List;

@Slf4j
@Tag(name = "Books Controller")
@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookService bookService;

    @Operation(
            summary = "Добавляет новую книгу в базу"
    )
    @PostMapping("/books")
    public void addBook(@RequestBody Book book) {
        bookService.saveDataBase(book);
    }

    //
    @Operation(
            summary = "Возвращает список всех книг"
    )
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getListBook();
    }

    //
    @Operation(
            summary = "Возвращает книгу по id"
    )
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable long id) {
        return bookService.getBook(id);
    }

    //
    @Operation(
            summary = "Обновляет информацию о книге"
    )
    @PutMapping("/books/{id}")
    public void updateBook(@RequestBody Book book) {
     bookService.updateBookInformation(book);
    }

    //
    @Operation(
            summary = "Удаляет книгу по id"
    )
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
    }
}

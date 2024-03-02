package com.romansayapin.Librarybookmanagementservice.servise.imp;

import com.romansayapin.Librarybookmanagementservice.entity.Book;
import com.romansayapin.Librarybookmanagementservice.exception.BookNotFoundByIdException;
import com.romansayapin.Librarybookmanagementservice.repository.BookRepository;
import com.romansayapin.Librarybookmanagementservice.servise.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    @Transactional
    public Book saveDataBase(Book book) {
        return bookRepository.save(book);
    }

    //
    @Override
    public List<Book> getListBook() {
        return bookRepository.findAll();
    }

    //
    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundByIdException(
                        String.format("Книги по id %d нет базе данных", id))
                );
    }

    //
    @Override
    @Transactional
    public Book updateBookInformation(Book book) {
       return bookRepository.findById(book.getId())
                .map(bookUpdate -> {
                    bookUpdate.setAuthor(book.getAuthor());
                    bookUpdate.setTitle(book.getTitle());
                    bookUpdate.setYear(book.getYear());
                    bookUpdate.setGenre(book.getGenre());
                    return bookUpdate;
                })
                .orElseThrow(() -> new BookNotFoundByIdException(
                String.format("Книги по id %d нет базе данных", book.getId()))
                );

    }

    //
    @Override
    @Transactional
    public Book deleteBook(Long id) {
        return bookRepository.deleteBookById(id).orElseThrow(() -> new BookNotFoundByIdException(
                String.format("Книги по id %d нет базе данных", id))
        );
    }
}

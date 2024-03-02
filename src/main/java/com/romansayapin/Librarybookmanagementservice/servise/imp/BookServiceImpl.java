package com.romansayapin.Librarybookmanagementservice.servise.imp;

import com.romansayapin.Librarybookmanagementservice.entity.Book;
import com.romansayapin.Librarybookmanagementservice.repository.BookRepository;
import com.romansayapin.Librarybookmanagementservice.servise.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
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
        return bookRepository.findById(id).orElseThrow();
    }

    //
    @Override
    public Book updateBookInformation(Book book) {
        if (!bookRepository.existsById(book.getId())) {
            return null;
        }
        return bookRepository.save(book);
    }

    //
    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

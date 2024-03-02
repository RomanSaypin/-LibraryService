package com.romansayapin.Librarybookmanagementservice.servise.imp;

import com.romansayapin.Librarybookmanagementservice.entity.Book;
import com.romansayapin.Librarybookmanagementservice.repository.BookRepository;
import com.romansayapin.Librarybookmanagementservice.servise.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public void saveDataBase(Book book) {
        bookRepository.save(book);
    }
//
    @Override
    public List<Book> getListBook() {
        return bookRepository.findAll();
    }
//
    @Override
    public Book getBook(long id) {
        return bookRepository.findById(id).orElseThrow();
    }
//
    @Override
    public void updateBookInformation(Book book) {
//        if (!bookRepository.existsById(book.getId())) {
//            return "There is no such book";
//        }
      bookRepository.save(book);
    }
//
    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }
}

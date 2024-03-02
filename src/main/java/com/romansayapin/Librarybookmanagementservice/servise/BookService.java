package com.romansayapin.Librarybookmanagementservice.servise;

import com.romansayapin.Librarybookmanagementservice.entity.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {

    Book saveDataBase(Book book);
    List<Book> getListBook();
    Book getBook(Long id);
    Book updateBookInformation(Book book);
    void deleteBook(Long id);

}

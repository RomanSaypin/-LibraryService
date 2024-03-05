package com.romansayapin.Librarybookmanagementservice.servise;

import com.romansayapin.Librarybookmanagementservice.entity.Book;

import java.util.List;

public interface BookService {

    Book saveDataBase(Book book);
    List<Book> getListBook();
    Book getBook(Long id);
    Book updateBookInformation(Book book);
    Book deleteBook(Long id);


}

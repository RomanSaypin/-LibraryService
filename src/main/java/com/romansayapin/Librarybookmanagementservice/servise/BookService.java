package com.romansayapin.Librarybookmanagementservice.servise;

import com.romansayapin.Librarybookmanagementservice.entity.Book;

import java.util.List;

public interface BookService {

    void saveDataBase(Book book);
    List<Book> getListBook();
    Book getBook(long id);
    void updateBookInformation(Book book);
    void deleteBook(long id);

}

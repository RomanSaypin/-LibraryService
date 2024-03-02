package com.romansayapin.Librarybookmanagementservice.repository;

import com.romansayapin.Librarybookmanagementservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

}

package com.omkar.BookApplication.repository;

import com.omkar.BookApplication.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
    public Book findBookByTitle(String title);
}

package com.example.spring.service;

import com.example.spring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}



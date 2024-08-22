package com.example.spring.controller;

import com.example.spring.repository.BookRepository;
import com.example.spring.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.spring.model.Book;

import java.util.Collection;
import java.util.HashMap;

@RestController
public class BookController {

    /* private BookService bookService;

     @Autowired
    public BookController(final BookService bookService) {
        this.bookService = bookService;
    } */

    private BookRepository bookRepository = new BookRepository();

    @PostMapping("/book")
    public void createBook(@RequestBody @Valid Book book) {
        bookRepository.addBook(book);
    }

    @GetMapping("/book")
    public Collection<Book> getBooks() {
        return bookRepository.getAll();
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable String id) {
        return bookRepository.getBook(id);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable String id) {
        bookRepository.deleteBook(id);
    }
}

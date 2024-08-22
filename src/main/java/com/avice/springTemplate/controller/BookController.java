package com.avice.springTemplate.controller;

import com.avice.springTemplate.service.BookService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;
import com.avice.springTemplate.model.Book;

@RestController
public class BookController {
  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping("/book")
  public void createBook(@RequestBody @Valid Book book) {
    bookService.addBook(book);
  }

  @GetMapping("/book")
  public Iterable<Book> getBooks() {
    return bookService.getAll();
  }

  @GetMapping("/book/{id}")
  public Book getBook(@PathVariable Integer id) {
    return bookService.getBook(id);
  }

  @DeleteMapping("/book/{id}")
  public void deleteBook(@PathVariable Integer id) {
    bookService.deleteBook(id);
  }
}

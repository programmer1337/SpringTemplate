package com.avice.springTemplate.service;

import com.avice.springTemplate.model.Book;
import com.avice.springTemplate.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  private final BookRepository bookRepository;

  @Autowired
  public BookService(final BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public void addBook(Book book) {
    bookRepository.save(book);
  }

  public Book getBook(Integer id) {
   return bookRepository.findById(id).orElse(null);
  }

  public Iterable<Book> getAll() {
    return bookRepository.findAll();
  }

  public void deleteBook(Integer id) {
    bookRepository.deleteById(id);
  }
}



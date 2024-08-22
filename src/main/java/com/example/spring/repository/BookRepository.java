package com.example.spring.repository;

import com.example.spring.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class BookRepository {
    private HashMap<String, Book> bookDB = new HashMap<>() {
        {
            put("1", new Book("1", "Clean Code", "Nobody"));
        }
    };

    public Book addBook(Book book) {
        book.setId(UUID.randomUUID().toString());
        bookDB.put(book.getId(), book);

        return book;
    }

    public Book getBook(String id) {
        Book book = bookDB.get(id);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return book;
    }

    public Collection<Book> getAll() {
        return bookDB.values();
    }

    public void deleteBook(String id) {
        Book book = bookDB.remove(id);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

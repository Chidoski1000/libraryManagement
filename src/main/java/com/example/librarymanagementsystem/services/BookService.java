package com.example.librarymanagementsystem.services;

import com.example.librarymanagementsystem.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {


    Book getBookByName(String name);

    Book getBookById(Long id);

    Book getBookByAuthor(String authorName);

    List<Book> getAllBooks();

    Book addBook(Book book);
}

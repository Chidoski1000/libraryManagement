package com.example.librarymanagementsystem.services;

import com.example.librarymanagementsystem.models.Book;
import com.example.librarymanagementsystem.models.Patron;

import java.util.List;
import java.util.Optional;

public interface BookService {


    Book getBookByName(String name);

    Book getBookById(Long id);

    Book getBookByAuthor(String authorName);

    List<Book> getAllBooks();

    void addBook(Book book);

    void removeBook(Long id, Patron patron);

    void returnBook(Long bookId);

    List<Book> getBookAvailable();

    List<Book> getMyBorrowedList(Patron patron);

    List<Book> getAllBorrowedList();
}

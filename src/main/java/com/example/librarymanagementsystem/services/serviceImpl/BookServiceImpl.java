package com.example.librarymanagementsystem.services.serviceImpl;

import com.example.librarymanagementsystem.models.Book;
import com.example.librarymanagementsystem.models.Patron;
import com.example.librarymanagementsystem.repositories.BookRepository;
import com.example.librarymanagementsystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getBookByName(String name) {
       Optional<Book> book = bookRepository.findByBookName(name);
       if(book.isPresent())return book.get();
       return null;
    }

    @Override
    public Book getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent())return book.get();
        return null;
    }

    @Override
    public Book getBookByAuthor(String authorName) {
        Optional<Book> book = bookRepository.findByAuthor(authorName);
        if(book.isPresent())return book.get();
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void addBook(Book book) {
            bookRepository.save(book);
    }

    @Override
    public void removeBook(Long bookId, Patron patron) {
        Book book = bookRepository.findById(bookId).get();
//        book.setPatron(patronList);
        book.setPatron(patron);
        bookRepository.save(book);
    }

    @Override
    public List<Book> getBookAvailable() {
        return bookRepository.findAllByPatronIsNull();
    }

    @Override
    public void returnBook(Long bookId) {
        Book book = bookRepository.findById(bookId).get();
        book.setPatron(null);
        bookRepository.save(book);
    }

    @Override
    public List<Book> getMyBorrowedList(Patron patron) {
        return bookRepository.findAllByPatron(patron);
    }

    @Override
    public List<Book> getAllBorrowedList() {
        return bookRepository.findAllByPatronIsNotNull();
    }
}

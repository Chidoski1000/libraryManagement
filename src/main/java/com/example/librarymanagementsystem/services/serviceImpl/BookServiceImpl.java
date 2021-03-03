package com.example.librarymanagementsystem.services.serviceImpl;

import com.example.librarymanagementsystem.models.Book;
import com.example.librarymanagementsystem.repositories.BookRepository;
import com.example.librarymanagementsystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
}

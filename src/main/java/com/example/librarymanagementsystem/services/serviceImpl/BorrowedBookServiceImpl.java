package com.example.librarymanagementsystem.services.serviceImpl;

import com.example.librarymanagementsystem.models.Book;
import com.example.librarymanagementsystem.repositories.BookRepository;
import com.example.librarymanagementsystem.services.BorrowedBookService;
import org.springframework.stereotype.Service;

@Service
public class BorrowedBookServiceImpl implements BorrowedBookService {
    private BookRepository bookRepository;

    public BorrowedBookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void removeBorrowedbook(long id) {
        Book book = bookRepository.findById(id).get();
//        BorrowedBook borrowedBook = (BorrowedBook) book;
    }

    @Override
    public void addBorrowedBook(long id) {

    }
}

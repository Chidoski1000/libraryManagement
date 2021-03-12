package com.example.librarymanagementsystem.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Book extends BaseModels{

    private String bookName;
    private String category;
    private String author;
    @OneToOne
    private Patron patron;

//    private Long quantity;

//    private String addBookToLibrary(Book book, int noOfBooks){
//        Book bookInLibrary = libraryRepostitory.findByBookNameAndCategoryAndAuthor(book.getBookName(), book.getCategory(),
//                book.getAuthor());
//        bookInLibrary.setQuantity(bookInLibrary.getQuantity() + noOfBooks);
//        libraryRepostitory.save(bookInLibrary);
//    }
//    @ManyToMany
//    @JoinTable(
//            name = "book_patron",
//            joinColumns = {@JoinColumn(name = "patronId")},
//            inverseJoinColumns = {@JoinColumn(name = "bookId")}
//    )
//    @OneToMany

//    @ManyToOne
//    private BorrowedBook borrowedBook;

}

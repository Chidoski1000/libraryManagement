package com.example.librarymanagementsystem.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Getter
@Setter
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long patronId;
    private String nameOfPatron;
    private String email;
    private String password;
    private boolean libraryCard;
//    @OneToOne
//    private Patron patron;

    /*@ManyToMany( mappedBy = "patron")
    private List<Book> book = new ArrayList<>();*/

//    @ManyToOne
//    @OneToOne
//    private Book book;
//    @OneToMany
//    private List<Book> book;
//    @JoinColumn(name = ("book_id"))

//    @OneToMany
//    private List<BorrowedBook> borrowedBook;

}

package com.example.librarymanagementsystem.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bookName;
    private String category;
    private String author;
    private Long quantity;
//    @ManyToOne
//    private BorrowerCard borrowerCard;

}

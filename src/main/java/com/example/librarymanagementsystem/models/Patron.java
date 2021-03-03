package com.example.librarymanagementsystem.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String nameOfPatron;
    private String email;
    private String password;
    private boolean libraryCard;

}

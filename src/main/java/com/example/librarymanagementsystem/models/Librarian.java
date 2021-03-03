package com.example.librarymanagementsystem.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Getter
@Setter
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String librarianName;
    private String email;
    private String password;
}

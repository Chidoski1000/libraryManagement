package com.example.librarymanagementsystem.services;

import com.example.librarymanagementsystem.models.Librarian;

import java.util.Optional;

public interface LibrarianService {

    Librarian getLibrarianById(Long id);

    Librarian getLibrarianByEmailAndPassword(String email, String password);
}

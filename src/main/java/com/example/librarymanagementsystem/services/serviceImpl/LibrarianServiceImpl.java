package com.example.librarymanagementsystem.services.serviceImpl;

import com.example.librarymanagementsystem.models.Librarian;
import com.example.librarymanagementsystem.models.Patron;
import com.example.librarymanagementsystem.repositories.LibrarianRepository;
import com.example.librarymanagementsystem.repositories.PatronRepository;
import com.example.librarymanagementsystem.services.LibrarianService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class LibrarianServiceImpl implements LibrarianService {
    private LibrarianRepository librarianRepository;

    @Autowired
    public LibrarianServiceImpl(LibrarianRepository librarianRepository) {
        this.librarianRepository = librarianRepository;
    }

    @Override
    public Librarian getLibrarianById(Long id) {
        Optional<Librarian> librarianOptional = librarianRepository.findById(id);
        return librarianOptional.orElse(null);
    }

    @Override
    public Librarian getLibrarianByEmailAndPassword(String email, String password) {
        log.info(email+password);
        return librarianRepository.findByEmailAndPassword(email, password).orElse(null);

    }
}

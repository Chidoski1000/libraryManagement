package com.example.librarymanagementsystem.repositories;

import com.example.librarymanagementsystem.models.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
    Optional<Librarian> findByEmailAndPassword(String email, String password);
}

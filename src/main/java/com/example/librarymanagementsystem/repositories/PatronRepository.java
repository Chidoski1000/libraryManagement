package com.example.librarymanagementsystem.repositories;

import com.example.librarymanagementsystem.models.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Long> {
    Optional<Patron> findByEmailAndPassword(String email, String password);

    List<Patron> findAllByLibraryCardFalse();
}

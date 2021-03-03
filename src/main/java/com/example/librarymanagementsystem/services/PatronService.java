package com.example.librarymanagementsystem.services;

import com.example.librarymanagementsystem.models.Patron;

import java.util.List;
import java.util.Optional;

public interface PatronService {

    Patron getPatronById(Long id);

    Patron getPatronByEmailAndPassword(String email, String password);

    Patron addPatron(Patron patron);

    List<Patron> getAllPatron();

    List<Patron> getAllPatronWithoutBorrowersCard();

    void updatePatron(Long employeeId);

}

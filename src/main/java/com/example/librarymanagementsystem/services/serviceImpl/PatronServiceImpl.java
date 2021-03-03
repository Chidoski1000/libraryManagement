package com.example.librarymanagementsystem.services.serviceImpl;

import com.example.librarymanagementsystem.models.Patron;
import com.example.librarymanagementsystem.repositories.PatronRepository;
import com.example.librarymanagementsystem.services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatronServiceImpl implements PatronService {

    private PatronRepository patronRepository;

    @Autowired
    public PatronServiceImpl(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    @Override
    public Patron getPatronById(Long id) {
        Optional<Patron> patronOptional = patronRepository.findById(id);
        if(patronOptional.isPresent())return patronOptional.get();
        return null;
    }

    @Override
    public Patron getPatronByEmailAndPassword(String email, String password) {
        return patronRepository.findByEmailAndPassword(email, password).orElse(null);
    }

    @Override
    public Patron addPatron(Patron patron) {
       return patronRepository.save(patron);
    }

    @Override
    public List<Patron> getAllPatron() {
        return patronRepository.findAll();
    }

    @Override
    public List<Patron> getAllPatronWithoutBorrowersCard() {
        return patronRepository.findAllByLibraryCardFalse();
    }

    @Override
    public void updatePatron( Long patronId) {
        Optional<Patron> thisPatron = patronRepository.findById(patronId);
        thisPatron.get().setLibraryCard(true);
        patronRepository.save(thisPatron.get());
    }
}

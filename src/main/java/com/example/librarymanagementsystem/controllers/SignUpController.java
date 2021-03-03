package com.example.librarymanagementsystem.controllers;

import com.example.librarymanagementsystem.models.Patron;
import com.example.librarymanagementsystem.services.LibrarianService;
import com.example.librarymanagementsystem.services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
    private LibrarianService librarianService;
    private PatronService patronService;

    @Autowired
    public SignUpController(LibrarianService librarianService, PatronService patronService) {
        this.librarianService = librarianService;
        this.patronService = patronService;
    }

    @GetMapping(path ="/signup")
    public String signUp(Model model){
        model.addAttribute("patron", new Patron());

        return "login";
    }

    @PostMapping(path ="/signup")
    public String signUp(@ModelAttribute("patron") Patron patron, Model model){
//        model.addAttribute("patronSignUp", new Patron());
        patronService.addPatron(patron);

        return "redirect:/login";
    }

}

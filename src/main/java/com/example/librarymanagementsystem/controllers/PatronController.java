package com.example.librarymanagementsystem.controllers;

import com.example.librarymanagementsystem.models.Patron;
import com.example.librarymanagementsystem.services.BookService;
import com.example.librarymanagementsystem.services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PatronController {

    private PatronService patronService;
    private BookService bookService;

    @Autowired
    public PatronController(PatronService patronService, BookService bookService) {
        this.patronService = patronService;
        this.bookService = bookService;
    }

    @GetMapping("/pat-dashboard")
    public String patronDashboard(Model model, HttpSession session){
        Object obj = session.getAttribute("thisPatron");
        if (obj == null) return "redirect:/login";

        Patron patron  = (Patron) (obj);
        model.addAttribute("bookList", bookService.getBookAvailable());
        model.addAttribute("librarianStock", "");
        if(patron.isLibraryCard()){
            return "patron-dashboard";
        }
        return "patron-noCard";
    }

    @GetMapping("/myBorrowedBooks")
    public String patronBorrowedList(Model model, HttpSession session){
        Object obj = session.getAttribute("thisPatron");
        if (obj == null) return "redirect:/login";

        Patron patron = (Patron) obj;
        model.addAttribute("borrowList", "");
        model.addAttribute("myBorrowedList", bookService.getMyBorrowedList(patron));
        return "patron-noCard";
    }
}

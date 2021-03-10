package com.example.librarymanagementsystem.controllers;

import com.example.librarymanagementsystem.models.Book;
import com.example.librarymanagementsystem.models.Librarian;
import com.example.librarymanagementsystem.models.Patron;
import com.example.librarymanagementsystem.services.BookService;
import com.example.librarymanagementsystem.services.LibrarianService;
import com.example.librarymanagementsystem.services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LibrarianController {
    private LibrarianService librarianService;
    private BookService bookService;
    private PatronService patronService;

    @Autowired
    public LibrarianController(LibrarianService librarianService, BookService bookService, PatronService patronService) {
        this.librarianService = librarianService;
        this.bookService = bookService;
        this.patronService = patronService;
    }

    @GetMapping("/lib-dashboard")
    public String librarianDashBoard(Model model, HttpSession session){
        model.addAttribute("list", "");
        model.addAttribute("patronList", patronService.getAllPatron());
        return "lib-dashboard";
    }


    @GetMapping("/book-stock")
    public String bookStock(Model model, HttpSession session){
        Object userObj = session.getAttribute("thisLibrarian");
        if (userObj == null) return "redirect:/login";

        Librarian lib  = (Librarian) (userObj);
        model.addAttribute("bookList", bookService.getAllBooks());
        model.addAttribute("librarianStock", "");
        return "lib-dashboard";
    }

    @GetMapping("/add-books")
    public String patronList(Model model, HttpSession session){
        Object userObj = session.getAttribute("thisLibrarian");
        if (userObj == null) return "redirect:/login";

        Book book = new Book();
        int quantity = 0;
        model.addAttribute("quantity", quantity);
        model.addAttribute("addbook", book);
        return "lib-dashboard";
    }

    @GetMapping("/borrowed-books")
    public String borrowedBooks(Model model, HttpSession session){
        Object userObj = session.getAttribute("thisLibrarian");
        if (userObj == null) return "redirect:/login";

        Librarian lib  = (Librarian) (userObj);
        model.addAttribute("borrowedBooks", "");
        model.addAttribute("borrowedBooksList", bookService.getAllBorrowedList());
        return "lib-dashboard";
    }

    @GetMapping("/borrowers-card")
    public String issueBorrowersCard(Model model, HttpSession session){
        Object userObj = session.getAttribute("thisLibrarian");
        if (userObj == null) return "redirect:/login";

        model.addAttribute("borrowersCard", "");
        model.addAttribute("noBorrowcard", patronService.getAllPatronWithoutBorrowersCard());
        return "lib-dashboard";
    }

    @GetMapping("/issueCard/{id}")
    public String issueBorrowerCard(@PathVariable(value = "id")long id, Model model){
        System.out.println("test mode");
        patronService.updatePatron(id);
        model.addAttribute("successCard", "Card issued successfully");
        return "redirect:/borrowers-card";
    }
}

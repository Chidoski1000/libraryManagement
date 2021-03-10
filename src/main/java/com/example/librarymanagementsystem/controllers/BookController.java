package com.example.librarymanagementsystem.controllers;

import com.example.librarymanagementsystem.models.Book;
import com.example.librarymanagementsystem.models.Patron;
import com.example.librarymanagementsystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    private BookService bookService;
    @Autowired

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("addbook") Book book, Model model, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("added book", "Book added successfully");
        bookService.addBook(book);
        return "redirect:/add-books";
    }

    @GetMapping("/borrowBook/{id}")
    public  String borrowBook(@PathVariable(value = "id") long id, Model model, HttpSession session){
        Object userObj = session.getAttribute("thisPatron");
        if (userObj == null) return "redirect:/login";
        Book book = bookService.getBookById(id);
//        book.setPatron((Patron) userObj);
        Patron patron = (Patron) userObj;
        bookService.removeBook(id, patron);
        return "redirect:/pat-dashboard";
    }

    @GetMapping("/returnBook/{id}")
    public String returnBook(@PathVariable(value = "id") long id, Model model, HttpSession session){
        Object userObj = session.getAttribute("thisPatron");
        if (userObj == null) return "redirect:/login";

        bookService.returnBook(id);
        return "redirect:/myBorrowedBooks";
    }
}

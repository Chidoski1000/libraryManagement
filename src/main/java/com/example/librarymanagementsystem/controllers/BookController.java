package com.example.librarymanagementsystem.controllers;

import com.example.librarymanagementsystem.models.Book;
import com.example.librarymanagementsystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
}

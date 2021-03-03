package com.example.librarymanagementsystem.controllers;

import com.example.librarymanagementsystem.dto.LoginRequestDto;
import com.example.librarymanagementsystem.models.Librarian;
import com.example.librarymanagementsystem.models.Patron;
import com.example.librarymanagementsystem.services.LibrarianService;
import com.example.librarymanagementsystem.services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private LibrarianService librarianService;
    private PatronService patronService;

    @Autowired
    public LoginController(LibrarianService librarianService, PatronService patronService) {
        this.librarianService = librarianService;
        this.patronService = patronService;
    }

    @GetMapping("/login")
    public String getLoginpage(Model model){
        model.addAttribute("userSignIn", new Patron());
        model.addAttribute("loginRequestDto", new LoginRequestDto());
        return "login";
    }

    @PostMapping("/login")
    public String getLoginpage(HttpSession session, Model model, RedirectAttributes redirectAttributes, @ModelAttribute("loginRequestDto") LoginRequestDto loginRequestDto){
        Librarian librarian1 = librarianService.getLibrarianByEmailAndPassword(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        Patron patron1 = patronService.getPatronByEmailAndPassword(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        if (librarian1 == null && patron1 == null) {
            redirectAttributes.addFlashAttribute("invalid", "User does not exist. Check login details or register.");
            return "redirect:/login";
        } else if(librarian1 != null) {
            model.addAttribute("list", "");
            model.addAttribute("patronList", patronService.getAllPatron());
            session.setAttribute("thisLibrarian", librarian1);
            return "redirect:/lib-dashboard";
        }else{
            model.addAttribute("name", patron1.getNameOfPatron());
            session.setAttribute("thisPatron", patron1);
            return "redirect:/pat-dashboard";
        }


    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login";
    }
}

package com.example.librarymanagementsystem.controllers;

import com.example.librarymanagementsystem.services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PatronController {
    @Autowired
    private PatronService patronService;

    @GetMapping("/pat-dashboard")
    public String employeeDashboard(Model model, HttpSession session){

        return "patron-dashboard";
    }
}

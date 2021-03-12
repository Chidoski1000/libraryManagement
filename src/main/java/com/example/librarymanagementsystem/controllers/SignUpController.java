package com.example.librarymanagementsystem.controllers;

import com.example.librarymanagementsystem.models.*;
import com.example.librarymanagementsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
//    private LibrarianService librarianService;
//    private PatronService patronService;
    private UserService userService;
    private PasswordEncoder passwordEncoder;
//    private RoleRepository roleRepository;

    @Autowired
    public SignUpController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping(path ="/signup")
    public String signUp(Model model){
        model.addAttribute("user", new UserDto());

        return "login";
    }

    @PostMapping(path ="/signup")
    public String signUp(@ModelAttribute("user") UserDto userDto, Model model) {
        User user = new User();
        Role role = new Role();
        if (userDto.getRole().toString().equalsIgnoreCase("LIBRARIAN") || userDto.getRole().toString().equalsIgnoreCase("PATRON")) {
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setEmail(userDto.getEmail());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//            role = roleRepository.findByERoles(ERoles.LIBRARIAN);
            user.setRoles(userDto.getRole());
            userService.addUser(user);

        }
        return "redirect:/login";
//    public String registerUser(@ModelAttribute ("appUser") UserDTO userDTO, Model model){
//        AppUser appUser = new AppUser();
//        Set<Role> roles = new HashSet<>();
//        if (userDTO.getRoles().equalsIgnoreCase("admin") || userDTO.getRoles().equalsIgnoreCase("customer"))
//            appUser.setFirstName(userDTO.getFirstName());
//        appUser.setLastName(userDTO.getLastName());
//        appUser.setEmail(userDTO.getEmail());
//        appUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
//        roles.add(roleRepository.findByAppUserRole(AppUserRole.ADMIN));
//        appUser.setRoles(roles);
//        appUserService.saveAppUser(appUser);
//        return "login";
//    }
    }
}

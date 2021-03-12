package com.example.librarymanagementsystem.services;

import com.example.librarymanagementsystem.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User getuserByEmail(String email);

    User addUser(User user);
}

package com.example.librarymanagementsystem.services.serviceImpl;

import com.example.librarymanagementsystem.models.User;
import com.example.librarymanagementsystem.repositories.UserRepository;
import com.example.librarymanagementsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getuserByEmail(String email) {
        return userRepository.findAllByEmail(email);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}

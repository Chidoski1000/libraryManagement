package com.example.librarymanagementsystem.models;

import lombok.Data;

@Data
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private ERoles role;
}

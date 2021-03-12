package com.example.librarymanagementsystem.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class User extends BaseModels{

    private String firstName;
    private String lastName;
    private String email;
    private String password;
//    @ManyToMany
//    @OneToOne
    @Enumerated(EnumType.STRING)
    private ERoles roles;
}

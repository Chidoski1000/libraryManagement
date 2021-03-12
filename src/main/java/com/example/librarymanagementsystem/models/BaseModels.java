package com.example.librarymanagementsystem.models;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class BaseModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}

package com.example.librarymanagementsystem.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Entity
@Data
public class Role extends BaseModels{

    @Enumerated(EnumType.STRING)
    private ERoles role;
}

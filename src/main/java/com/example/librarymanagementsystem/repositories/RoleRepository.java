package com.example.librarymanagementsystem.repositories;

import com.example.librarymanagementsystem.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
//    Role find
}

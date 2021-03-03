package com.example.librarymanagementsystem.repositories;

import com.example.librarymanagementsystem.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByBookName(String bookName);
    Optional<Book> findByAuthor(String authorName);

}

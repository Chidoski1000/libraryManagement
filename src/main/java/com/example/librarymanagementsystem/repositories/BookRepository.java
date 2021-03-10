package com.example.librarymanagementsystem.repositories;

import com.example.librarymanagementsystem.models.Book;
import com.example.librarymanagementsystem.models.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByBookName(String bookName);
    Optional<Book> findByAuthor(String authorName);
//    List<Book> findAllByQuantityAfter(long after);
    List<Book> findAllByPatronIsNull();
    List<Book> findAllByPatron(Patron patron);
    List<Book> findAllByPatronIsNotNull();

}

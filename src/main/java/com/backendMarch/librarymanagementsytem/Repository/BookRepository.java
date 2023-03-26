package com.backendMarch.librarymanagementsytem.Repository;

import com.backendMarch.librarymanagementsytem.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {

}

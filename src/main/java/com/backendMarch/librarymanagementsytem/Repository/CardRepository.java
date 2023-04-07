package com.backendMarch.librarymanagementsytem.Repository;

import com.backendMarch.librarymanagementsytem.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository <LibraryCard,Integer>{

}

package com.backendMarch.librarymanagementsytem.Repository;

import com.backendMarch.librarymanagementsytem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository <Student,Integer>{
 Student findByEmail(String email );  // custom search based on attribute
 List<Student> findByAge(int age);
}

package com.backendMarch.librarymanagementsytem.Repository;

import com.backendMarch.librarymanagementsytem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository <Student,Integer>{
 Student findByEmail(String email );
 List<Student> findByAge(int age);
}

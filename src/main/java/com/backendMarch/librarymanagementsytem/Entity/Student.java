package com.backendMarch.librarymanagementsytem.Entity;

import com.backendMarch.librarymanagementsytem.Enum.CardStatus;
import com.backendMarch.librarymanagementsytem.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;
import java.awt.*;

@Entity   // create table with following attribute
 @NoArgsConstructor         // anotation for contructor
 @AllArgsConstructor
 @Getter
 @Setter                   // getter and setter annotation
public class Student {

    @Id       // define primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // generate value for primary key unique for all attribute
    private int id;
    private String name;
    private int age;

     @Enumerated (EnumType.STRING)    // enum class annottation
     private Department department;

     @Column(unique = true)
     private String email;
                           // * before saving any enity you have to set all its atrribute, *either take from user or set at back end *
     @OneToOne(mappedBy = "student",cascade = CascadeType.ALL) // when new student is created new library card is created by cascade
     LibraryCard libraryCard;   // i changed variable name

}

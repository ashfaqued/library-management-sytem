package com.backendMarch.librarymanagementsytem.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity   // create table with following attributeim
@NoArgsConstructor         // anotation for contructor
@AllArgsConstructor
@Getter
@Setter                   // getter and setter annotation

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String name;
    private int age;
    private String mobNo;
    private String email;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book> books = new ArrayList<>();

}

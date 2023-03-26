package com.backendMarch.librarymanagementsytem.Entity;

import com.backendMarch.librarymanagementsytem.Enum.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity   // create table with following attribute
@NoArgsConstructor         // anotation for contructor
@AllArgsConstructor
@Getter
@Setter                   // getter and setter annotation

public class Book {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int price;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Author author;



}

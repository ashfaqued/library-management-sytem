package com.backendMarch.librarymanagementsytem.Controller;

import com.backendMarch.librarymanagementsytem.DTO.BookRequestDto;
import com.backendMarch.librarymanagementsytem.DTO.BookResponseDto;
import com.backendMarch.librarymanagementsytem.Entity.Book;
import com.backendMarch.librarymanagementsytem.Service.Bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    Bookservice  bookservice;

    @PostMapping("/add")

    public BookResponseDto addBook(@RequestBody BookRequestDto bookRequestDto) throws Exception {
//        try{
//            bookservice.addbook(book);
//        }
//        catch(Exception e){
//            throw new RuntimeException(e.getMessage()+"book not added");
//        }
//        return "Book added successfully";
    return bookservice.addbook(bookRequestDto);
    }
}

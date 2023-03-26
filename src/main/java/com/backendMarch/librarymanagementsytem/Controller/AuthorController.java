package com.backendMarch.librarymanagementsytem.Controller;

import com.backendMarch.librarymanagementsytem.Entity.Author;
import com.backendMarch.librarymanagementsytem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){

        authorService.addAuthor(author);
        return "Author Add Successfully";

    }
    @GetMapping("/get_authors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }
}

package com.backendMarch.librarymanagementsytem.Service;

import com.backendMarch.librarymanagementsytem.DTO.BookRequestDto;
import com.backendMarch.librarymanagementsytem.DTO.BookResponseDto;
import com.backendMarch.librarymanagementsytem.Entity.Author;
import com.backendMarch.librarymanagementsytem.Entity.Book;
import com.backendMarch.librarymanagementsytem.Repository.AuthorRepository;
import com.backendMarch.librarymanagementsytem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Bookservice {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    public BookResponseDto addbook(BookRequestDto bookRequestDto) throws Exception {
//        Author author;
//        try {
//             author = authorRepository.findById(book.getAuthor().getId()).get();
//        }
//        catch(Exception e) {
//           throw new Exception("Author not present");
//           //return "Book not added";               // this return msg not working .. last return msg get executed
//        }
//
//        List<Book> bookswritten =author.getBooks();
//        bookswritten.add(book);
//        authorRepository.save(author);
//        return "Book is added Successfully";

        // get th aauthor object
        Author author= authorRepository.findById(bookRequestDto.getAuthorId()).get();
        Book book= new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setGenre(bookRequestDto.getGenre());
        book.setPrice(bookRequestDto.getPrice());
        book.setIssued(false);
        book.setAuthor(author);

        author.getBooks().add(book);
        authorRepository.save(author);   // will save both book and author. author is parent

        // create response using responsedto
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setPrice(book.getPrice());

        return bookResponseDto;

    }

}

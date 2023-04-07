package com.backendMarch.librarymanagementsytem.Service;

import com.backendMarch.librarymanagementsytem.DTO.IssueBookRequestDto;
import com.backendMarch.librarymanagementsytem.DTO.IssueBookResponseDto;
import com.backendMarch.librarymanagementsytem.Entity.Book;
import com.backendMarch.librarymanagementsytem.Entity.LibraryCard;
import com.backendMarch.librarymanagementsytem.Entity.Transaction;
import com.backendMarch.librarymanagementsytem.Enum.CardStatus;
import com.backendMarch.librarymanagementsytem.Enum.TransactionStatus;
import com.backendMarch.librarymanagementsytem.Repository.BookRepository;
import com.backendMarch.librarymanagementsytem.Repository.CardRepository;
import com.backendMarch.librarymanagementsytem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    BookRepository bookRepository;

    @Autowired

    private JavaMailSender emailSender;

    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {

       // create transaction Object
        Transaction transaction=new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssuedOperation(true);

        // 1 step
       LibraryCard card;
        try{
        card=cardRepository.findById(issueBookRequestDto.getCardId()).get();
    }
        catch(Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            transaction.setMessage("Invalid card");
            throw new Exception("Invalid card");
        }
        Book book;
        try{
            book= bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch(Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            transaction.setMessage("Book not found /Invalid Id");
            throw new Exception("Book not found or Invalid Id");

        }
        // both card and bok are valid
        transaction.setBook(book);
        transaction.setCard(card);

        if (book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);

            transaction.setMessage("Sorry Book is already issued");
            transactionRepository.save(transaction);   // save db after setting msg
            throw new Exception("Sorry Book is already issued");

                   }
        if (card.getCardStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);


            transaction.setMessage("Your Card is not Active");
            transactionRepository.save(transaction);           // save db after setting msg
            throw  new Exception("Your Card is not Active");

        }
          // now issue book
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setMessage("Transaction was succesful");

        book.setIssued(true);
        book.setCard(card);
        book.getTransaction().add(transaction);
        card.getTransactionList().add(transaction);
        card.getBookIssued().add(book);

        // card is parent entity ... so saving card will save all 3 object card,book transaction
        cardRepository.save(card);

        //prepare response dto
        IssueBookResponseDto issueBookResponseDto= new IssueBookResponseDto();
        issueBookResponseDto.setTransanctionId(transaction.getTransactionNumber());
        issueBookResponseDto.setTransactionStatus(TransactionStatus.SUCCESS);
        issueBookResponseDto.setBookName(book.getTitle());

           // email implementation
          String text ="Congrats"+card.getStudent()+ "You have been issued "+ book.getTitle()+"book";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("lmsbackend3@gmail.com");
        message.setTo(card.getStudent().getEmail());
        message.setSubject("Issue Book Notification");
        message.setText(text);
        emailSender.send(message);

        return issueBookResponseDto;


    }
}

package com.backendMarch.librarymanagementsytem.Service;

import com.backendMarch.librarymanagementsytem.Entity.LibraryCard;
import com.backendMarch.librarymanagementsytem.Entity.Student;
import com.backendMarch.librarymanagementsytem.Enum.CardStatus;
import com.backendMarch.librarymanagementsytem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;


    public void  addStudent(Student student){
        // set value for card
        LibraryCard libraryCard= new LibraryCard();
        libraryCard.setCardStatus(CardStatus.ACTIVATED);
        libraryCard.setValidTill("03/2025");
        libraryCard.setStudent(student);

        // set the card attribute in student
        student.setLibraryCard(libraryCard);
        studentRepository.save(student);

    }
}

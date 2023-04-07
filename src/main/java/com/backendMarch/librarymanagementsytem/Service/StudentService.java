package com.backendMarch.librarymanagementsytem.Service;

import com.backendMarch.librarymanagementsytem.DTO.StudentRequestDto;
import com.backendMarch.librarymanagementsytem.DTO.StudentResponseDto;
import com.backendMarch.librarymanagementsytem.DTO.StudentUpadteEmailRequestDto;
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


    public void  addStudent(StudentRequestDto studentRequestDto){
        // set value for card
       // LibraryCard libraryCard= new LibraryCard();
        //libraryCard.setCardStatus(CardStatus.ACTIVATED);
        //libraryCard.setValidTill("03/2025");
        //libraryCard.setStudent(student);

        // set the card attribute in student
        //student.setLibraryCard(libraryCard);
        //studentRepository.save(student);

        // new implimentation using dto
         // create a student object
        Student  student= new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setEmail(studentRequestDto.getEmail());


        // create a card object

        LibraryCard card = new LibraryCard();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudent(student);

        //set card
        student.setLibraryCard(card);


        // check
        //will saveboth card and student
        studentRepository.save(student);
    }
    public String findByEmail(String email){
        Student student= studentRepository.findByEmail(email);
        return student.getName();
    }

    public StudentResponseDto updateEmail(StudentUpadteEmailRequestDto studentUpadteEmailRequestDto){
        Student student= studentRepository.findById(studentUpadteEmailRequestDto.getId()).get();
        student.setEmail(studentUpadteEmailRequestDto.getEmail());

        // update step
        Student updatedStudent = studentRepository.save(student);

        // convert updated student to response dto
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(updatedStudent.getId());
        studentResponseDto.setName(updatedStudent.getName());
        studentResponseDto.setEmail(updatedStudent.getEmail());

        return new StudentResponseDto();
    }
}

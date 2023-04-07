package com.backendMarch.librarymanagementsytem.Controller;

import com.backendMarch.librarymanagementsytem.DTO.StudentRequestDto;
import com.backendMarch.librarymanagementsytem.DTO.StudentResponseDto;
import com.backendMarch.librarymanagementsytem.DTO.StudentUpadteEmailRequestDto;
import com.backendMarch.librarymanagementsytem.Entity.Student;
import com.backendMarch.librarymanagementsytem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping ("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
      studentService.addStudent(studentRequestDto);
      return "Student Added Successfully";
    }
    @GetMapping("/find_by_email")   // api for search for custom attribute
    public String findStudentByEmail(@RequestParam("email") String email){
        return studentService.findByEmail(email);
    }

    // write api to get student of particular age

    // try for same other attribute

    @PutMapping("/update_email")
    public StudentResponseDto updateEmail(@RequestBody StudentUpadteEmailRequestDto studentUpadteEmailRequestDto){
        return studentService.updateEmail(studentUpadteEmailRequestDto);

    }
}

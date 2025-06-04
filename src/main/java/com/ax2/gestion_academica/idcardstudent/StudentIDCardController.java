package com.ax2.gestion_academica.idcardstudent;

import com.ax2.gestion_academica.student.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * created by Angela , 02/06/2025
 */
@RestController
@RequestMapping("academia/student_id_card")
@CrossOrigin(origins = "http://localhost:3000") // Permite peticiones desde React
public class StudentIDCardController {

    @Autowired
    private final StudentIdCardService studentIdCardService;

    public StudentIDCardController(StudentIdCardService studentIdCardService) {
        this.studentIdCardService = studentIdCardService;
    }

    @GetMapping
    public List<StudentIdCard> getStudents(){
        return studentIdCardService.getIdCards();
    }

    @GetMapping(path = "{id}")
    public Optional<StudentIdCard> getStudentByIdCard(@PathVariable("id")Long id){
        return studentIdCardService.getByIdCard(id);
    }





}

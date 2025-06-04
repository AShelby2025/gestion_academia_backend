package com.ax2.gestion_academica.idcardstudent;

import com.ax2.gestion_academica.student.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * created by Angela , 02/06/2025
 */
@RestController
@RequestMapping("api/student_id_card")
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

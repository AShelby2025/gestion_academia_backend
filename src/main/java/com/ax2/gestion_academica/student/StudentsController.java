package com.ax2.gestion_academica.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * created by sinNombre on Mar, 27/03/2025
 */
@RestController
@RequestMapping("gestion_academica/students")
public class StudentsController {

    @Autowired
    private final StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Students>getStudents(){
        return studentService.getStudents();
    }

    @GetMapping(path = "{id}")
    public Optional<Students> getById(@PathVariable("id")Long id){
        return studentService.getById(id);
    }

   @PostMapping
    public void addNewStudent(@RequestBody Students students){
        studentService.addNewStudent(students);
   }

   @DeleteMapping(path = "{id}")
    public void deleteStudents(@PathVariable("id")Long id){
        studentService.deleteStudent(id);
   }

   @PutMapping(path = "{id}")
    public void updateStudent(
            @PathVariable("id")Long id,
            @RequestParam (required=false) String first_name,
            @RequestParam (required=false) String last_name,
            @RequestParam (required=false) String email){
        studentService.updateStudent(id, first_name, last_name, email);
   }



//da error
 /*   @GetMapping("/api/students/count")
    public String countStudents(){
        return studentService.countStudents();
    }*/


}

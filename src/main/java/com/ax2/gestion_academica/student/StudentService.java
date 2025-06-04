package com.ax2.gestion_academica.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * created by sinNombre on Mar, 27/03/2025
 */
@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Students> getStudents() {
        return studentRepository.findAll();
    }

    public Optional<Students> getById(Long id) {
        boolean exist = studentRepository.existsById(id);
        if (!exist) {
            throw new IllegalStateException(" Student with id " + id + " does not exist, idiota ");
        }
        return studentRepository.findById(id);
    }


    //http://localhost:8080/api/students
    public void addNewStudent(Students students) {
        Optional<Students> optionalStudents=studentRepository.findStudentByEmail(students.getEmail());
        if(optionalStudents.isPresent()){
            throw new IllegalStateException(" Email no disponible- ya esta cogido ");
        }
        studentRepository.save(students);
    }


    public void deleteStudent(Long id) {
        boolean exist=studentRepository.existsById(id);
        if(!exist){
            throw  new IllegalStateException("No hay student con ese id ");
        }
        studentRepository.deleteById(id);
    }

    public void updateStudent(Long id, String firstName, String lastName, String email) {

        Students students=studentRepository.findById(id)
                .orElseThrow(() ->new IllegalStateException("Student with ID "+ id+ " no existe"));

        if(firstName!=null && firstName.length()>0 && !Objects.equals(students.getFirst_name(), firstName)){
            students.setFirst_name(firstName);
        }
        if(lastName!=null && lastName.length()>0 && !Objects.equals(students.getLast_name(), lastName)){
            students.setLast_name(lastName);
        }

        //miro si est el email
        Optional<Students> optionalStudents=studentRepository.findStudentByEmail(email);
        if(optionalStudents.isPresent()){
            throw new IllegalStateException(" Email no disponible ");
        }
        students.setEmail(email);

    }


// da error
    /*public String countStudents() {
        int total= (int) studentRepository.count();
        System.out.println(total);
        return String.valueOf(total);
    }*/
}

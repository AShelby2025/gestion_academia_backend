package com.ax2.gestion_academica.idcardstudent;

import com.ax2.gestion_academica.student.Students;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * created by Angela on Mar, 02/06/2025
 */
@Service
public class StudentIdCardService {

    private final StudentIdCardRepository studentIdCardRepository;

    public StudentIdCardService(StudentIdCardRepository studentIdCardRepository) {
        this.studentIdCardRepository = studentIdCardRepository;
    }

    public List<StudentIdCard> getIdCards(){
        Iterable<StudentIdCard> iterable = studentIdCardRepository.findAll();; // Tu objeto iterable
        List<StudentIdCard> list = new ArrayList<>();
        iterable.forEach(list::add);
        return  list;
    }

    public Optional<StudentIdCard> getByIdCard(Long id){
        boolean exist = studentIdCardRepository.existsById(id);
        if (!exist) {
            throw new IllegalStateException(" Student with id " + id + " does not exist, idiota ");
        }
        return studentIdCardRepository.findById(id);
    }


}

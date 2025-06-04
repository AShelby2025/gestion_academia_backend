package com.ax2.gestion_academica.idcardstudent;

import com.ax2.gestion_academica.student.Students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * created by sinNombre on Mar, 27/03/2025
 */
@Repository
public interface StudentIdCardRepository extends JpaRepository<StudentIdCard, Long> {

   // public List<StudentIdCard> findbyIdStudent(Long studentId);

}

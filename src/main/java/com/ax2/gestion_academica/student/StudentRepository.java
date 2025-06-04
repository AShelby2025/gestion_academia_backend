package com.ax2.gestion_academica.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * created by Angela on Mar, 02/06/2025
 */
@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {

    @Query("SELECT s FROM Students s WHERE s.email = ?1")
    Optional<Students> findStudentByEmail(String email);


}

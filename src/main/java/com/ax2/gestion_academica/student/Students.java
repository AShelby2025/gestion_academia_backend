package com.ax2.gestion_academica.student;


import jakarta.persistence.Column;
import jakarta.persistence.*;

/**
 * created by Angela on Mar, 02/06/2025
 */
@Entity(name= "Students")
@Table(name="Students",
uniqueConstraints = { @UniqueConstraint(name="student_email_uk", columnNames = "email")})
public class Students {
    @Id
    @SequenceGenerator(
            name ="students_sequence",
            sequenceName ="students_sequence",
            allocationSize = 1 // va ingresar de uno a uno
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "students_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private  Long id;

    @Column(
            name = "first_name",
            nullable = false,// not null
            columnDefinition = "TEXT" // ahora es var 245
    )
    private String first_name;
    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT" // ahora es var 245
    )
    private String last_name;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT" // ahora es var 245
           // unique = true // unique key
    )
    private String email;

    @Column(
            name = "age",
            nullable = false
    )
    private Integer age;

    public Students() {
    }

    public Students(Long id, String first_name, String last_name, String email, Integer age) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.age = age;
    }

    public Students(String first_name, String last_name, String email, Integer age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}

package com.ax2.gestion_academica;


import com.ax2.gestion_academica.student.StudentRepository;
import com.ax2.gestion_academica.student.Students;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * created by sinNombre on Mar, 26/03/2025
 */
@Configuration
public class Config_app {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Students maria = new Students( // sin id
                    "maria",
                    "Martin",
                    "Maria@email",
                    22);

            Students jose = new Students(
                    "jose",
                    "Lopez",
                    "jose@gmail.com",
                    27);

            repository.saveAll(List.of(maria, jose));

        };

         }

}

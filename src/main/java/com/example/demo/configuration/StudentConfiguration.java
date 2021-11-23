package com.example.demo.configuration;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entities.StudentEntity;
import com.example.demo.repository.StudentRepository;

@Configuration
public class StudentConfiguration {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> { 
			StudentEntity Shivani = new StudentEntity("Shivani", "shiv@gmail.com", LocalDate.of(1996, 11, 9));	
			StudentEntity Raksha = new StudentEntity("Raksha", "raksha@gmail.com", LocalDate.of(1997, 6, 20));	
			repository.saveAll(List.of(Shivani, Raksha));
		};
		
	}
	
}

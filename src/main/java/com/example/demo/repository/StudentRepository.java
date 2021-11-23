package com.example.demo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long>{
	
	//jpql
//	@Query("SELECT s FROM studentEntity s WHERE s.email = ?1")
	Optional<StudentEntity> findStudentByEmail(String email);
	
}

package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Student;
import com.example.demo.entities.StudentEntity;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getStudents() {

		List<StudentEntity> entityList = studentRepository.findAll();

		Student student = null;
		List<Student> beanList = new ArrayList<>();
		for (StudentEntity entity : entityList) {
			student = new Student();
			BeanUtils.copyProperties(entity, student);
			beanList.add(student);
		}
		return beanList;
	}

	public String hello(Long id) {
		if (id == 1L) {
			return "Say hello to the world Shivani";
		} else {
			return "Say hello to the world Raksha";
		}
	}

	public Student addNewStudent(Student student) {
		Optional<StudentEntity> existingStudent = studentRepository.findStudentByEmail(student.getEmail());
		
		if (existingStudent.isPresent()) {
			throw new IllegalStateException("Email Taken");
		}
		StudentEntity entity = new StudentEntity();
		BeanUtils.copyProperties(student, entity);
		studentRepository.save(entity);
		return student;
	}
}

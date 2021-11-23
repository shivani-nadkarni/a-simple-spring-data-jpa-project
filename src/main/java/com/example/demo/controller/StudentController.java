package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;

	@GetMapping(path = "/all")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	
	@GetMapping(path = "/hello/{id}")
	public String hello(@PathVariable Long id) {
		return studentService.hello(id);
	}
	
	@PostMapping
	public Student registerNewStudent(@RequestBody Student student) {
		return studentService.addNewStudent(student);
	}
	
}

package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
@Service
public interface StudentService {
	List<Student> getStudents();
	
	Student addStudent(Student student);
	
	Student updateStudent(int id,Student student);
	
	void deleteStudent(int id);
	

}

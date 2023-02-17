package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<List<Student>>(studentService.getStudents(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.addStudent(student),HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id,@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateStudent(id, student),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id){
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Student with id "+id+" is deleted.",HttpStatus.OK);
	}
	

}

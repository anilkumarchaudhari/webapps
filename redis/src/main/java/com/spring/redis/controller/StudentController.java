package com.spring.redis.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.redis.entity.Student;
import com.spring.redis.service.StudentService;


@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		Student createResponse = studentService.save(student);
		return createResponse;
	}

	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		Student updateResponse = studentService.update(student);
		return updateResponse;
	}

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable int id) {
		Student getReponse = null;
		try {
			getReponse = studentService.get(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getReponse;
	}
	
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	

	@DeleteMapping(value = "/delete/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteStudent(@PathVariable("id") Integer id) {
		studentService.delete(id);
		return "Record deleted succesfully";
	}
}
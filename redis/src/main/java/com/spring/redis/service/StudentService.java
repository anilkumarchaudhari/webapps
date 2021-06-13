package com.spring.redis.service;
import java.util.List;

import org.springframework.stereotype.Service;
import com.spring.redis.entity.Student;


@Service
public interface StudentService {
	public Student save(Student student);

	public Student update(Student student);

	public Student get(int id) throws Exception;

	public void delete(Integer id);
	
	public List<Student> getStudents();
}
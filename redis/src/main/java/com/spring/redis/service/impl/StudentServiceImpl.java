package com.spring.redis.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.redis.entity.Student;
import com.spring.redis.repository.StudentRepository;
import com.spring.redis.service.StudentService;

@Component
public class StudentServiceImpl implements StudentService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Transactional
	@CachePut(value = "student",key = "#student.id")  //update the value into cache
	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		log.info("add student called");
		
		return studentRepository.save(student);
	}

	@Transactional
	@CachePut(value = "student",key = "#student.id")  //update the value into cache
	@Override
	public Student update(Student student) {
		// TODO Auto-generated method stub
		log.info("update student called");
		return studentRepository.save(student);
	}

	@Transactional
	@Cacheable(value = "student",key = "#id") //resullt of calling method should be cached
	@Override
	public Student get(int id) throws Exception  {
		// TODO Auto-generated method stub
		Student s=null;
		Optional<Student>optionalStudent=studentRepository.findById(id);
		if(optionalStudent.isPresent())
			s= optionalStudent.get();
		else 
			throw new Exception("Record not found");
	return s;
		
	}
	
	@Transactional
	@CacheEvict(value = "student", key = "#id") //remove data from cache
	@Override
	public void delete(Integer id) {
		log.info("delete student called");
		studentRepository.deleteById(id);;
	}

	@Transactional
	@Cacheable(value = "studentList")
	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		List<Student> studentList=new ArrayList<Student>();
		Iterable<Student> studs= studentRepository.findAll();
		studs.forEach(x -> studentList.add(x));
		return studentList;
	}

}

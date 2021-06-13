package com.spring.redis.repository;
import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.redis.entity.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student,Serializable> {
	
}
package com.java.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.springboot.entity.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{

}

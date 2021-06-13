package com.spring.crud.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.crud.domain.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
   List<Post>  findAll();
   Post findByTitle(String title);
   
   Optional<Post> findById(Long Id);
}

package com.java.springboot.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.entity.Author;
import com.java.springboot.entity.Post;
import com.java.springboot.repository.AuthorRepository;
import com.java.springboot.repository.PostRepository;

@Service
public class DataLoader {
    private AuthorRepository authorRepository;
    private PostRepository postRepository;
    
    @Autowired
	public DataLoader(AuthorRepository authorRepository, PostRepository postRepository) {
		this.authorRepository = authorRepository;
		this.postRepository = postRepository;
	}
    
   /* @PostConstruct
    public void doPost() {
    	//create author
    	Author au= new Author("Anilkumar","Chaudhari","anilkumar@gmail.com");
    	//au.setId(2L);
    	authorRepository.save(au);
    	//create post
    	Post post=new Post("My First Post");
    	post.setBody("My post is so nice");
    	post.setPostedOn(new Date());
    	post.setAuthor(au);
    	//post.setId(3L);
    	postRepository.save(post);	
    }*/
    
}

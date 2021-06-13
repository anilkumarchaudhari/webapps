package com.spring.crud.dao;


/*
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.crud.domain.Post;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class PostDaoTest {
	
	@Autowired
	PostRepository postRepository;
	
	
	@Before
	public void init() {
		System.out.println("init called");
		
	}
	
	@Test
	public void testfindAllPost() {
		
		List<Post> posts= postRepository.findAll();
		assertEquals(6, posts.size());
	}

	@Test
	public void testfindPostByTitle() {
		String title="John Blog Post 1";
		Post post=postRepository.findByTitle(title);
		assertEquals(title, post.getTitle());
	}
	
	@Test
	public void testCreatePost() {
		Post post=setPost();
		Post postAdded=postRepository.save(post);
		assertEquals(post.getTitle(), postAdded.getTitle());
	}

	public Post setPost() {
		
		Post post=new Post();
		post.setTitle("Microservices");
		post.setSlug("Microservices Tutorial");
		post.setTeaser("Microservices Architecture");
		post.setBody("Microservices Application");
		post.setPostedOn(new Date());
		return post;
	}
  
}
*/
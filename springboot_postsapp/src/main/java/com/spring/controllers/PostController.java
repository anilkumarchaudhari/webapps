package com.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.models.Post;
import com.spring.models.User;
import com.spring.services.PostService;

@RestController
public class PostController {

	private PostService postService;

	@Autowired
	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	//Ext Endpoint: https://jsonplaceholder.typicode.com/posts
	//get all posts -- RestTemplate
	@GetMapping("/posts")
	public List<Post> getPosts(){
		return postService.getPosts();
	}

	//Ext Endpoint: https://jsonplaceholder.typicode.com/posts
	//get all posts -- Feign Clients
	@GetMapping("/feign/posts")
	public List<Post> getPosts_Feign(){
		return postService.getPosts_Feign();
	}

	//Ext Endpoint: https://jsonplaceholder.typicode.com/posts/id
	//get post by id -- RestTemplate
	@GetMapping("/post/{id}")
	public Post getPostById(@PathVariable("id") Long id){
		return postService.getPostById(id);
	}

	//Ext Endpoint: https://jsonplaceholder.typicode.com/posts/id
	//get post by id -- FeignClient
	@GetMapping("/feign/post/{id}")
	public Post getPostById_Feign(@PathVariable("id") Long id){
		return postService.getPostById_Feign(id);
	}

	//Ext Endpoint: https://jsonplaceholder.typicode.com/users
	//get all users -- RestTemplate
	@GetMapping("/users")
	public List<User> getUsers(){
		return postService.getUsers();
	}

	//Ext Endpoint: https://jsonplaceholder.typicode.com/users/id
	//get user by id -- RestTemplate
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") Long id){
		return postService.getUserById(id);
	}

	//Ext Endpoint: https://jsonplaceholder.typicode.com/users/id/posts
	//get user by id with all posts -- RestTemplate
	@GetMapping("/user/{id}/posts")
	public User getUserWithPosts(@PathVariable("id") Long id){
		return postService.getUserWithPosts(id);
	}
}

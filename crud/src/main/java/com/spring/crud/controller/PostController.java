package com.spring.crud.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.domain.Post;
import com.spring.crud.service.PostService;


@RestController
public class PostController {
	
	@Autowired(required = true)
	private PostService postService;

	/*@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}*/

    //Get all the data
	@RequestMapping(value="/posts",method=RequestMethod.GET )
	List<Post> findAllPost(){
		//vehicle.execute();
		return postService.findAll();
	}

	//Get Request Mapping
	//HATEOAS
	@RequestMapping(value="/post/{id}",method=RequestMethod.GET)
	ResponseEntity<Post> getPostByID(@PathVariable("id") Long id) throws Exception {
		if(id==5)
			throw new Exception("Invalid post with id "+id);
		Optional<Post> post= postService.findById(id);	
		
		if(post.isPresent()) {
			//"all-users",SERVER_PATH+"/users"
			//HATEOAS
			return new ResponseEntity<>(post.get(), HttpStatus.OK);
		}
		return null;
	}
	//Delete Request Mapping
	@RequestMapping(value="/post/delete/{id}",method=RequestMethod.DELETE)
	void deleteById(@PathVariable("id") Long id) {
		postService.deletePost(id);
	}
	//Create Request Mapping
	@RequestMapping(value="/post/add",method=RequestMethod.POST)
	Post addPost(@RequestBody Post post) {
		return postService.createPost(post);
	}
	
	//Update Request Mapping
	@RequestMapping(value="/post/update/{id}",method=RequestMethod.PUT)
	Post updatePost(@PathVariable("id")Long id ,@RequestBody Post post) {
		Post updatedPost = postService.findById(id).get();
		updatedPost.setTitle(post.getTitle());
		updatedPost.setSlug(post.getSlug());
		updatedPost.setBody(post.getBody());
		updatedPost.setPostedOn(new Date());
		updatedPost.setTeaser(post.getTeaser());
		
		return postService.update(id, updatedPost);
	}
	
	
}

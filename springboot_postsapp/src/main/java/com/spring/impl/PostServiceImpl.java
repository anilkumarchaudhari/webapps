package com.spring.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.models.Post;
import com.spring.models.User;
import com.spring.proxy.PostFeignProxy;
import com.spring.services.PostService;

@Service
public class PostServiceImpl implements PostService{

    private PostFeignProxy postFeignProxy;
    
    @Autowired
	public void setPostFeignProxy(PostFeignProxy postFeignProxy) {
		this.postFeignProxy = postFeignProxy;
	}

	@Override
	public List<Post> getPosts() {
		ResponseEntity<Post[]> responseEntity=new RestTemplate().getForEntity("https://jsonplaceholder.typicode.com/posts", Post[].class);
		Post[] postArrays=responseEntity.getBody();
		return Arrays.asList(postArrays);
	}

	@Override
	public Post getPostById(Long id) {
		Map<String,String> params= new HashMap<String,String>();
		params.put("id", String.valueOf(id));	
		ResponseEntity<Post> responseEntity=new RestTemplate().getForEntity("https://jsonplaceholder.typicode.com/posts/{id}", Post.class,params);
		Post responseObj=responseEntity.getBody();
		return responseObj;
	}

	@Override
	public List<Post> getPosts_Feign() {
		return postFeignProxy.getPost();
	}

	@Override
	public Post getPostById_Feign(Long id) {
		return postFeignProxy.getPostById(id);
	}

	@Override
	public List<User> getUsers() {
		ResponseEntity<User[]> responseEntity=new RestTemplate().getForEntity("https://jsonplaceholder.typicode.com/users", User[].class);
		User[] postArrays=responseEntity.getBody();
		return Arrays.asList(postArrays);
	}

	@Override
	public User getUserById(Long id) {
		Map<String,String> params=new HashMap<String,String>();
		params.put("id", String.valueOf(id));
		ResponseEntity<User> responseEntity= new RestTemplate().getForEntity("https://jsonplaceholder.typicode.com/users/{id}", User.class, params);
		User obj=responseEntity.getBody();
		return obj;
	}

	@Override
	public User getUserWithPosts(Long id) {
		ResponseEntity<User> responseUser= new RestTemplate().getForEntity("https://jsonplaceholder.typicode.com/users/{id}", User.class, id);
		ResponseEntity<Post[]> responseEntityPosts= new RestTemplate().getForEntity("https://jsonplaceholder.typicode.com/users/{id}/posts", Post[].class, id);
        User user= responseUser.getBody();
        List<Post> posts=Stream.of(responseEntityPosts.getBody()).collect(Collectors.toList());
		user.setPosts(posts);
        return user;
	}

}

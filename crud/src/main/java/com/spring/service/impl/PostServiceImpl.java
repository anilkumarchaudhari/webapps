package com.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.dao.PostRepository;
import com.spring.crud.dao.UserRepository;
import com.spring.crud.domain.Post;
import com.spring.crud.service.PostService;

@Service("postService")
public class PostServiceImpl implements PostService {

	private PostRepository postRepository;
	
	@Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
	
	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public Optional<Post> findById(Long id) {
		return postRepository.findById(id);
	}

	@Override
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public void deletePost(Long id) {
		postRepository.deleteById(id);
	}

	@Override
	public Post update(Long id, Post post) {
		return postRepository.save(post);
	}

	@Override
	public Post findByTitle(String title) {
		// TODO Auto-generated method stub
		return postRepository.findByTitle(title);
	}

}

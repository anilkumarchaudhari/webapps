package com.java.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.java.springboot.entity.Post;
import com.java.springboot.repository.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public List<Post>findAllByAuthorFirstName(String first) {
		return postRepository.findAllByAuthorFirstNameIgnoreCaseOrderByPostedOnDesc(first);
	}
	

	public Post findPostBySlug(String slug) {
		return postRepository.findPostBySlug(slug);
	}
	public Post findPostBySlugQuery(String slug) {
		return postRepository.findPostBySlugQuery(slug);
	}
	public Post findPostBySlugQueryParam(String slug) {
		return postRepository.findPostBySlugQueryParam(slug);
	}
	
	public List<Post> findActivePost(Boolean active){
		return postRepository.findPostByActive(active);
	}

	public List<Post> findInActivePost(){
		return postRepository.findPostByActiveFalse();
	}

	public List<Post> byKeyword(String keyword) {
		// TODO Auto-generated method stub
		return postRepository.findPostBykeywordsIgnoreCase(keyword);
	}
	public List<Post> byKeywordLike(String keyword) {
		// TODO Auto-generated method stub
		return postRepository.findAllByKeywordsLikeIgnoreCase('%'+keyword+'%');
	}
	public List<Post> PostByAuthorFirstNameAndKeywords(String firstname,String keywords) {
		return postRepository.findAllByAuthorFirstNameAndKeywordsIgnoreCase(firstname, keywords);
	}
	
}

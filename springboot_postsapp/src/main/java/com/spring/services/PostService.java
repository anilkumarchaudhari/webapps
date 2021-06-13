package com.spring.services;

import java.util.List;

import com.spring.models.Post;
import com.spring.models.User;

public interface PostService {
    List<Post> getPosts();
    Post getPostById(Long id);
    List<Post> getPosts_Feign();
    Post getPostById_Feign(Long id);
    List<User> getUsers();
    User getUserById(Long id);
    User getUserWithPosts(Long id);
}

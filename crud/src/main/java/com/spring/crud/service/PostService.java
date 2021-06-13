package com.spring.crud.service;

import java.util.List;
import java.util.Optional;
import com.spring.crud.domain.Post;

public interface PostService {
      List<Post> findAll();
      Optional<Post> findById(Long id);
      Post createPost(Post post);
      void deletePost(Long id);
      Post update(Long id ,Post post);
      Post findByTitle(String title);
}

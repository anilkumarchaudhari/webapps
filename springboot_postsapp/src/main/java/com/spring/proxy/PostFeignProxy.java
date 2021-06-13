package com.spring.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.models.Post;

@FeignClient(name="PostFeignProxy" ,url = "https://jsonplaceholder.typicode.com")
public interface PostFeignProxy {
    @GetMapping("/posts")
    public List<Post> getPost();
    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable("id") Long id);
}

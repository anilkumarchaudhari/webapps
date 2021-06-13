package com.java.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.springboot.entity.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long>{
   //firstname
	List<Post> findAllByAuthorFirstNameIgnoreCaseOrderByPostedOnDesc(String first);
	//slug
	Post findPostBySlug(String slug);
	//active
	List<Post> findPostByActive(Boolean active);
	//inactive
	List<Post> findPostByActiveFalse();
	//Keywords
	List<Post> findPostBykeywordsIgnoreCase(String keyword);
	List<Post> findAllByKeywordsLikeIgnoreCase(String keyword);
	
	//Author firstname and Keywords
	List<Post> findAllByAuthorFirstNameAndKeywordsIgnoreCase(String firstname,String keywords);
	List<Post> findAllByAuthorFirstNameAndKeywordsOrderByPostedOnDesc(String firstname,String keywords);
	
	//slug by @Query
	//query should be written in HQL lang default
	@Query("select p from Post p where p.slug=?1")
	Post findPostBySlugQuery(String slug);
	
	//@Query("select p from Post p where p.slug=:slug")
	//Post findPostBySlugQueryParam(@Param("slug")String slug);
	
	//nativeQuery = true mean you can write query in your data base like SQL
	@Query(value="select * from post p where p.slug=:slug",nativeQuery = true)
	Post findPostBySlugQueryParam(@Param("slug")String slug);
	
}

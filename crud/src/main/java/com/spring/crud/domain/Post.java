package com.spring.crud.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(columnDefinition = "TEXT")
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String slug;
	
	@Column(columnDefinition = "TEXT")
	private String body;
	
	@Column(columnDefinition = "TEXT")
	private String teaser;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date postedOn;
	

	public Post() {
		//super();
		// TODO Auto-generated constructor stub
	}

	public Post(String title, String body, String teaser,String slug, Date postedOn) {
		this.title = title;
		this.body = body;
		this.teaser = teaser;
		this.slug=slug;
		this.postedOn = postedOn;
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTeaser() {
		return teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}
	

}


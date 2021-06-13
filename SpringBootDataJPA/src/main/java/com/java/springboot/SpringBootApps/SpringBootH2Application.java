package com.java.springboot.SpringBootApps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.java.springboot.repository.PostRepository;


@SpringBootApplication
@ComponentScan("com.java.springboot")
@EntityScan(basePackages = {"com.java.springboot"})  // scan JPA entities
@EnableJpaRepositories("com.java.springboot.repository")  //scan JPA repo when pkg is different
public class SpringBootH2Application {
	Logger logger=LoggerFactory.getLogger(SpringBootH2Application.class);
    
	//PostRepository
	private PostRepository postRepository;
	
	//@Autowired
	//private DataLoader dataLoader;
	
	@Autowired
	public SpringBootH2Application(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootH2Application.class, args);
	}
	
	//PostConstruct
/*	@PostConstruct
	 void doPost() {
		logger.error("doPost called");
		for(Post post:postRepository.findAll()) {
			logger.error(post+"\n");
		}
	}*/

}

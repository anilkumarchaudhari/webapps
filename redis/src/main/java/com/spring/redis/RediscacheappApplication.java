package com.spring.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.spring.redis.entity.Student;
import com.spring.redis.repository.StudentRepository;

import jdk.jfr.Enabled;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.spring.redis")
@EnableCaching
public class RediscacheappApplication implements CommandLineRunner{
	
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(RediscacheappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Student s1 = new Student("Anil","anil@gmail.com","1E","Mumbai University");
		Student s2 = new Student("Anuraj","anuraj@gmail.com","2E","Rajasthan University");
		Student s3 = new Student("Mahendra","mahendra@gmail.com","3E","UP University");
		Student s4 = new Student("Alok","alok@gmail.com","5E","Mumbai University");
		Student s5 = new Student("Sanket","sanket@gmail.com","4E","Karnataka University");
		studentRepository.save(s1);
		studentRepository.save(s2);
		studentRepository.save(s3);
		studentRepository.save(s4);
		studentRepository.save(s5);
		
	}

}

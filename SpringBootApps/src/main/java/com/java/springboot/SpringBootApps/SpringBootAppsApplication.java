package com.java.springboot.SpringBootApps;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.java.springboot.data.User;

@ComponentScan({"com.java"})
@SpringBootApplication
@EnableCaching
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class SpringBootAppsApplication {
    private static Logger LOGGER = LogManager.getLogger(SpringBootAppsApplication.class);

	@Bean
	public User user() {
		return new User("anil","kumar");
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppsApplication.class, args);
		
        LOGGER.info("Simple log statement with inputs 1, 2 and 3");

	}

}

package com.java.springboot.configuration;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class AutoConfigureApplication {

	public static void main(String[] args) {

		SpringApplication.run(AutoConfigureApplication.class, args);
	}

}

package com.java.springboot.SpringBootApps;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
     
	@GetMapping("/hello")
	public String showHellow() {
		return "Hellow World";
	}
}

package com.java.springboot.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
	
	@Value("${spring.profiles.active}")
	private String environment;
	@Value("${msg}")
	private String msg;
	@GetMapping("/")
	public String showHellow() {
		return msg;
	}
}

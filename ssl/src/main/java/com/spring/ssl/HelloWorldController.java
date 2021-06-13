package com.spring.ssl;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    
	@RequestMapping(value = "/get/{name}",produces = MediaType.TEXT_PLAIN_VALUE,method = RequestMethod.GET)
	public String getHellow(@PathVariable("name") String nme) {
		return "Hello World "+nme;
	}
}

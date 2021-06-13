package com.java.springboot.SpringBootApps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.service.NotificationService;

@RestController

public class PageController {
	//property injection
  //  @Autowired
	//private NotificationService notificationService;
	@Value("${pagecontroller.msg}")
	private String msg;
	
	@Value("${random.value}")
	private String random;
	private NotificationService notificationService;
	//const injection
	@Autowired
	public PageController(NotificationService notificationService) {
		this.notificationService = notificationService;
		System.out.println("const injection");
	}


	//setter injection
	/*@Autowired
	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
		System.out.println("Setter Injection called1");
	}*/


	@RequestMapping("/")
	public String home() {
		return notificationService.toString();
	}
	@RequestMapping("/msg")
	public String homeMsg() {
		return msg.toString()+" "+random;
	}
}

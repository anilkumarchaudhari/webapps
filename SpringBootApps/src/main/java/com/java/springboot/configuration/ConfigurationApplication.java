package com.java.springboot.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.java.springboot.data.MyConfigApp;

@ComponentScan("com.java.springboot")
@SpringBootApplication
@EnableConfigurationProperties
public class ConfigurationApplication {
	
    public static void main(String []args) {
    	ApplicationContext ctx=SpringApplication.run(ConfigurationApplication.class, args);
    	MyConfigApp myConfigApp=(MyConfigApp) ctx.getBean("myConfigApp");
    	System.out.println(myConfigApp);
    	
    	System.out.println(ctx.getBean("datasource").toString());
    }
}

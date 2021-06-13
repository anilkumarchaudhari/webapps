package com.spring.batch.batchapplication;

import java.io.IOException;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@SpringBootApplication
public class BatchapplicationApplication {
	
	@Value("${csv.file.path}")
	private static String path;
	private static Resource resource;
	public static void main(String[] args) throws IOException {
		SpringApplication.run(BatchapplicationApplication.class, args);
		
	}

}

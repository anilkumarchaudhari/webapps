package com.spring.batch.batchapplication;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


@RestController
@RequestMapping("/load")
public class LoadController {
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	@GetMapping
	public BatchStatus executeJob() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {

		//pass job params
		Map<String ,JobParameter> map =new HashMap<>();
		map.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters parameters= new JobParameters(map);
		
		//trigger a job
		JobExecution jobExecution=jobLauncher.run(job, parameters);
		
		System.out.println("JobExecution status "+jobExecution.getStatus());
		
		while(jobExecution.isRunning()) {
			System.out.println(" .... running");
		}
		
		return jobExecution.getStatus();
	}
}

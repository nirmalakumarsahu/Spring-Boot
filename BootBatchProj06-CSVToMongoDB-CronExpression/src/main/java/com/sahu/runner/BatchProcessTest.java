package com.sahu.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchProcessTest  {
	
	@Autowired
	private JobLauncher launcher;
	
	@Autowired
	private Job job;
	
	@Scheduled(cron = "${cron.expr}")
	public void runJob() throws Exception {
		//Prepare JobParameters
		JobParameters parameter = new JobParametersBuilder()
								.addLong("time", System.currentTimeMillis())
								.toJobParameters();
		//Run the job
		try {
			JobExecution execution = launcher.run(job, parameter);
			System.out.println("Job completion status : "+execution.getStatus());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

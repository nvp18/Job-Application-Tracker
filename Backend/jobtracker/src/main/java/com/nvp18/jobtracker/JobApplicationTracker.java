package com.nvp18.jobtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
public class JobApplicationTracker {

	public static void main(String[] args) {
		SpringApplication.run(JobApplicationTracker.class, args);
	}

}

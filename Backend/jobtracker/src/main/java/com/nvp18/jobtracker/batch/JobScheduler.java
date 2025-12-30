package com.nvp18.jobtracker.batch;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.parameters.JobParameters;
import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobScheduler {

    @Autowired
    private JobOperator jobOperator;

    @Autowired
    private Job fetchAndProcessJob;

    @Scheduled(cron = "0 */2 * * * ?")
    public  void runJobs() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time",System.currentTimeMillis())
                .toJobParameters();
        jobOperator.start(fetchAndProcessJob,jobParameters);
    }
}

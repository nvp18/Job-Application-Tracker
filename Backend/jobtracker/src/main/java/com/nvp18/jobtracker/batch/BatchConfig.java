package com.nvp18.jobtracker.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;

    public BatchConfig(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
        this.jobRepository = jobRepository;
        this.platformTransactionManager = platformTransactionManager;
    }

    @Bean
    public Step fetchJobsStep(ItemReader atsReader, ItemProcessor jobProcessor, ItemWriter jobWriter) {
        return new StepBuilder("fetchJobsStep", jobRepository)
                .chunk(1)
                .reader(atsReader)
                .processor(jobProcessor)
                .writer(jobWriter)
                .transactionManager(platformTransactionManager)
                .build();

    }

    @Bean
    public Job fetchAndProcessJob(Step fetchJobsStep) {
        return new JobBuilder("fetchAndProcessJobs",jobRepository).start(fetchJobsStep).build();
    }
}

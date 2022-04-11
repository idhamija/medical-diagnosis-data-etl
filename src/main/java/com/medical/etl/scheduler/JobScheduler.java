package com.medical.etl.scheduler;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class JobScheduler {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    //    For every 15s
//    @Scheduled(cron = "*/15 * * * * *")
    //  For every friday at 18:00
    @Scheduled(cron = "0 0 18 ? * FRI")
    public BatchStatus etl() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
        JobExecution jobExecution = jobLauncher.run(job, jobParameters);

        System.out.println("######## Status: " + jobExecution.getStatus() + ", Called By: Scheduler");
        return jobExecution.getStatus();
    }

}

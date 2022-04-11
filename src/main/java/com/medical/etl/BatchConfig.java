package com.medical.etl;

import com.medical.etl.model.*;
import com.medical.etl.processor.*;
import com.medical.etl.reader.*;
import com.medical.etl.writer.*;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private final int chunkSize = 100;
    private final int skipLimit = Integer.MAX_VALUE;

    @Autowired
    @Qualifier("source")
    private DataSource sourceDataSource;

    @Autowired
    @Qualifier("target")
    private DataSource targetDataSource;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    // Doctor Table //
    @Bean
    public DoctorReader doctorReader() {
        return new DoctorReader(sourceDataSource);
    }

    @Bean
    public DoctorProcessor doctorProcessor() {
        return new DoctorProcessor();
    }

    @Bean
    public DoctorWriter doctorWriter() {
        return new DoctorWriter(targetDataSource);
    }

    @Bean
    public Step doctorStep() {
        return this.stepBuilderFactory
                .get("Populate dim_doctor table.")
                .<Doctor, Doctor>chunk(chunkSize)
                .reader(doctorReader())
                .processor(doctorProcessor())
                .writer(doctorWriter())
                .faultTolerant()
                .skip(EmptyResultDataAccessException.class)
                .skipLimit(skipLimit)
                .build();
    }

    // Lab Table //
    @Bean
    public LabReader labReader() {
        return new LabReader(sourceDataSource);
    }

    @Bean
    public LabProcessor labProcessor() {
        return new LabProcessor();
    }

    @Bean
    public LabWriter labWriter() {
        return new LabWriter(targetDataSource);
    }

    @Bean
    public Step labStep() {
        return this.stepBuilderFactory
                .get("Populate dim_lab table.")
                .<Lab, Lab>chunk(chunkSize)
                .reader(labReader())
                .processor(labProcessor())
                .writer(labWriter())
                .faultTolerant()
                .skip(EmptyResultDataAccessException.class)
                .skipLimit(skipLimit)
                .build();
    }

    // Patient Table //
    @Bean
    public PatientReader patientReader() {
        return new PatientReader(sourceDataSource);
    }

    @Bean
    public PatientProcessor patientProcessor() {
        return new PatientProcessor();
    }

    @Bean
    public PatientWriter patientWriter() {
        return new PatientWriter(targetDataSource);
    }

    @Bean
    public Step patientStep() {
        return this.stepBuilderFactory
                .get("Populate dim_patient table.")
                .<Patient, Patient>chunk(chunkSize)
                .reader(patientReader())
                .processor(patientProcessor())
                .writer(patientWriter())
                .faultTolerant()
                .skip(EmptyResultDataAccessException.class)
                .skipLimit(skipLimit)
                .build();
    }

    // TestType Table //
    @Bean
    public TestTypeReader testTypeReader() {
        return new TestTypeReader(sourceDataSource);
    }

    @Bean
    public TestTypeProcessor testTypeProcessor() {
        return new TestTypeProcessor();
    }

    @Bean
    public TestTypeWriter testTypeWriter() {
        return new TestTypeWriter(targetDataSource);
    }

    @Bean
    public Step testTypeStep() {
        return this.stepBuilderFactory
                .get("Populate dim_test_type table.")
                .<TestType, TestType>chunk(chunkSize)
                .reader(testTypeReader())
                .processor(testTypeProcessor())
                .writer(testTypeWriter())
                .faultTolerant()
                .skip(EmptyResultDataAccessException.class)
                .skipLimit(skipLimit)
                .build();
    }

    // Date Table //
    @Bean
    public DateReader dateReader() {
        return new DateReader(sourceDataSource);
    }

    @Bean
    public DateProcessor dateProcessor() {
        return new DateProcessor();
    }

    @Bean
    public DateWriter dateWriter() {
        return new DateWriter(targetDataSource);
    }

    @Bean
    public Step dateStep() {
        return this.stepBuilderFactory
                .get("Populate dim_date table.")
                .<Date, Date>chunk(chunkSize)
                .reader(dateReader())
                .processor(dateProcessor())
                .writer(dateWriter())
                .faultTolerant()
                .skip(EmptyResultDataAccessException.class)
                .skipLimit(skipLimit)
                .build();
    }

    // Time Table //
    @Bean
    public TimeReader timeReader() {
        return new TimeReader(sourceDataSource);
    }

    @Bean
    public TimeProcessor timeProcessor() {
        return new TimeProcessor();
    }

    @Bean
    public TimeWriter timeWriter() {
        return new TimeWriter(targetDataSource);
    }

    @Bean
    public Step timeStep() {
        return this.stepBuilderFactory
                .get("Populate dim_time table.")
                .<Time, Time>chunk(chunkSize)
                .reader(timeReader())
                .processor(timeProcessor())
                .writer(timeWriter())
                .faultTolerant()
                .skip(EmptyResultDataAccessException.class)
                .skipLimit(skipLimit)
                .build();
    }

    // Prescription Table //
    @Bean
    public PrescriptionReader prescriptionReader() {
        return new PrescriptionReader(sourceDataSource);
    }

    @Bean
    public PrescriptionProcessor prescriptionProcessor() {
        return new PrescriptionProcessor();
    }

    @Bean
    public PrescriptionWriter prescriptionWriter() {
        return new PrescriptionWriter(targetDataSource);
    }

    @Bean
    public Step prescriptionStep() {
        return this.stepBuilderFactory
                .get("Populate dim_prescription table.")
                .<Prescription, Prescription>chunk(chunkSize)
                .reader(prescriptionReader())
                .processor(prescriptionProcessor())
                .writer(prescriptionWriter())
                .faultTolerant()
                .skip(EmptyResultDataAccessException.class)
                .skipLimit(skipLimit)
                .build();
    }

    // TestReport Table //
    @Bean
    public TestReportReader testReportReader() {
        return new TestReportReader(sourceDataSource);
    }

    @Bean
    public TestReportProcessor testReportProcessor() {
        return new TestReportProcessor();
    }

    @Bean
    public TestReportWriter testReportWriter() {
        return new TestReportWriter(targetDataSource);
    }

    @Bean
    public Step testReportStep() {
        return this.stepBuilderFactory
                .get("Populate fact_test_report table.")
                .<TestReportSource, TestReportTarget>chunk(chunkSize)
                .reader(testReportReader())
                .processor(testReportProcessor())
                .writer(testReportWriter())
                .faultTolerant()
                .skip(EmptyResultDataAccessException.class)
                .skipLimit(skipLimit)
                .build();
    }

    @Bean
    public Job etlJob() {
        return this.jobBuilderFactory
                .get("ETL job.")
                .incrementer(new RunIdIncrementer())
                .start(doctorStep())
                .next(labStep())
                .next(patientStep())
                .next(testTypeStep())
                .next(dateStep())
                .next(timeStep())
                .next(prescriptionStep())
                .next(testReportStep())
                .build();
    }

}

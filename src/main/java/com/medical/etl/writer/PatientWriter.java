package com.medical.etl.writer;

import com.medical.etl.model.Patient;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class PatientWriter extends JdbcBatchItemWriter<Patient> {

    final String sqlQuery = "INSERT IGNORE INTO dim_patient(patient_id,gender,weight,height,state,city,district) " +
            "VALUES(:id,:gender,:weight,:height,:state,:city,:district)";

    public PatientWriter(DataSource dataSource) {
        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Patient>());
        this.setDataSource(dataSource);
        this.setSql(sqlQuery);
    }

}
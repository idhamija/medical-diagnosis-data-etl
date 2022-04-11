package com.medical.etl.writer;

import com.medical.etl.model.Doctor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class DoctorWriter extends JdbcBatchItemWriter<Doctor> {

    final String sqlQuery = "INSERT IGNORE INTO dim_doctor(doctor_id,doctor_name,department,hospital_name,state,city,district,pincode) " +
            "VALUES(:id,:name,:department,:hospital,:state,:city,:district,:pincode)";

    public DoctorWriter(DataSource dataSource) {
        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Doctor>());
        this.setDataSource(dataSource);
        this.setSql(sqlQuery);
    }

}

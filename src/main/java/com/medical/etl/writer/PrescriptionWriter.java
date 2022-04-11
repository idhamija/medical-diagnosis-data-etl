package com.medical.etl.writer;

import com.medical.etl.model.Prescription;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class PrescriptionWriter extends JdbcBatchItemWriter<Prescription> {

    final String sqlQuery = "INSERT IGNORE INTO dim_prescription(prescription_id,doctor_id,date_id,diagnosis,treatment) " +
            "VALUES(:id,:doctorId,:date,:diagnosis,:treatment)";

    public PrescriptionWriter(DataSource dataSource) {
        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Prescription>());
        this.setDataSource(dataSource);
        this.setSql(sqlQuery);
    }

}

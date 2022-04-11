package com.medical.etl.writer;

import com.medical.etl.model.TestReportTarget;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class TestReportWriter extends JdbcBatchItemWriter<TestReportTarget> {

    final String sqlQuery = "INSERT IGNORE INTO fact_test_report(test_report_id,test_type_id,patient_id,doctor_id,prescription_id,lab_id,date_id,time_id,patient_age,test_value,severity,test_timestamp) " +
            "VALUES(:id,:testTypeId,:patientId,:doctorId,:prescriptionId,:labId,:date,:timeId,:patientAge,:testValue,:severity,:testTimestamp)";

    public TestReportWriter(DataSource dataSource) {
        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<TestReportTarget>());
        this.setDataSource(dataSource);
        this.setSql(sqlQuery);
    }

}

package com.medical.etl.writer;

import com.medical.etl.model.Lab;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class LabWriter extends JdbcBatchItemWriter<Lab> {

    final String sqlQuery = "INSERT IGNORE INTO dim_lab(lab_id,lab_name,state,city,district,pincode) " +
            "VALUES(:id,:name,:state,:city,:district,:pincode)";

    public LabWriter(DataSource dataSource) {
        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Lab>());
        this.setDataSource(dataSource);
        this.setSql(sqlQuery);
    }

}

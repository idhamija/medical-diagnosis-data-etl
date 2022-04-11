package com.medical.etl.writer;

import com.medical.etl.model.TestType;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class TestTypeWriter extends JdbcBatchItemWriter<TestType> {

    final String sqlQuery = "INSERT IGNORE INTO dim_test_type(test_type_id,test_name,min_value,max_value,unit) " +
            "VALUES(:id,:name,:minValue,:maxValue,:unit)";

    public TestTypeWriter(DataSource dataSource) {
        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<TestType>());
        this.setDataSource(dataSource);
        this.setSql(sqlQuery);
    }

}

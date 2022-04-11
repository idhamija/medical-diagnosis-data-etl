package com.medical.etl.writer;

import com.medical.etl.model.Time;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class TimeWriter extends JdbcBatchItemWriter<Time> {

    final String sqlQuery = "INSERT IGNORE INTO dim_time(time_id,hour,minute) " +
            "VALUES(:timeId,:hour,:minute)";

    public TimeWriter(DataSource dataSource) {
        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Time>());
        this.setDataSource(dataSource);
        this.setSql(sqlQuery);
    }

}

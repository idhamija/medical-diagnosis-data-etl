package com.medical.etl.writer;

import com.medical.etl.model.Date;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class DateWriter extends JdbcBatchItemWriter<Date> {

    final String sqlQuery = "INSERT IGNORE INTO dim_date(date_id,year,month,day) " +
            "VALUES(:dateId,:year,:month,:day) ";

    public DateWriter(DataSource dataSource) {
        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Date>());
        this.setDataSource(dataSource);
        this.setSql(sqlQuery);
    }

}

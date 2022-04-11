package com.medical.etl.reader;

import com.medical.etl.model.Date;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DateReader extends JdbcCursorItemReader<Date> {

    final String sqlQuery = "SELECT DATE(visit_timestamp) AS date FROM visit " +
            "UNION " +
            "SELECT prescription_date AS date FROM prescription";

    public DateReader(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.setSql(sqlQuery);
        this.setRowMapper(new DateReader.DateRowMapper());
    }

    private static class DateRowMapper implements RowMapper<Date> {

        @Override
        public Date mapRow(ResultSet rs, int rowNum) throws SQLException {
            Date date = new Date();
            date.setDateId(rs.getDate("date"));
            return date;
        }

    }

}

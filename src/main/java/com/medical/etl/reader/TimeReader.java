package com.medical.etl.reader;

import com.medical.etl.model.Time;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TimeReader extends JdbcCursorItemReader<Time> {

    final String sqlQuery = "SELECT TIME(visit_timestamp) time " +
            "FROM visit";

    public TimeReader(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.setSql(sqlQuery);
        this.setRowMapper(new TimeReader.TimeRowMapper());
    }

    private static class TimeRowMapper implements RowMapper<Time> {

        @Override
        public Time mapRow(ResultSet rs, int rowNum) throws SQLException {
            Time time = new Time();
            time.setTime(rs.getTime("time"));
            return time;
        }

    }

}

package com.medical.etl.reader;

import com.medical.etl.model.TestType;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTypeReader extends JdbcCursorItemReader<TestType> {

    final String sqlQuery = "SELECT test_type_id,test_name,min_value,max_value,unit " +
            "FROM test_type";

    public TestTypeReader(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.setSql(sqlQuery);
        this.setRowMapper(new TestTypeReader.TestTypeRowMapper());
    }

    private static class TestTypeRowMapper implements RowMapper<TestType> {

        @Override
        public TestType mapRow(ResultSet rs, int rowNum) throws SQLException {
            TestType testType = new TestType();
            testType.setId(rs.getInt("test_type_id"));
            testType.setName(rs.getString("test_name"));
            testType.setMinValue(rs.getDouble("min_value"));
            testType.setMaxValue(rs.getDouble("max_value"));
            testType.setUnit(rs.getString("unit"));
            return testType;
        }

    }

}

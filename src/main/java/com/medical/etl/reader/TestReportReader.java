package com.medical.etl.reader;

import com.medical.etl.model.TestReportSource;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestReportReader extends JdbcCursorItemReader<TestReportSource> {

    final String sqlQuery = "SELECT test_report_id,test_type_id,patient_id,doctor_id,prescription_id,lab_id,test_value,test_image,visit_timestamp,test_name,dob " +
            "FROM test_report JOIN visit USING(visit_id) JOIN test_type USING(test_type_id) JOIN patient USING(patient_id)";

    public TestReportReader(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.setSql(sqlQuery);
        this.setRowMapper(new TestReportReader.TestReportRowMapper());
    }

    private static class TestReportRowMapper implements RowMapper<TestReportSource> {

        @Override
        public TestReportSource mapRow(ResultSet rs, int rowNum) throws SQLException {
            TestReportSource testReportSource = new TestReportSource();
            testReportSource.setId(rs.getInt("test_report_id"));
            testReportSource.setTestTypeId(rs.getInt("test_type_id"));
            testReportSource.setPatientId(rs.getInt("patient_id"));
            testReportSource.setDoctorId(rs.getInt("doctor_id"));
            testReportSource.setPrescriptionId(rs.getInt("prescription_id"));
            testReportSource.setLabId(rs.getInt("lab_id"));
            testReportSource.setTestValue(rs.getDouble("test_value"));
            testReportSource.setTestTimestamp(rs.getTimestamp("visit_timestamp"));
            testReportSource.setTestName(rs.getString("test_name"));
            testReportSource.setPatientDob(rs.getDate("dob"));
            return testReportSource;
        }

    }

}

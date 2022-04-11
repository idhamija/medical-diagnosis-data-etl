package com.medical.etl.reader;

import com.medical.etl.model.Prescription;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrescriptionReader extends JdbcCursorItemReader<Prescription> {

    final String sqlQuery = "SELECT prescription_id,doctor_id,prescription_date,diagnosis,treatment " +
            "FROM prescription";

    public PrescriptionReader(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.setSql(sqlQuery);
        this.setRowMapper(new PrescriptionReader.PrescriptionRowMapper());
    }

    private static class PrescriptionRowMapper implements RowMapper<Prescription> {

        @Override
        public Prescription mapRow(ResultSet rs, int rowNum) throws SQLException {
            Prescription prescription = new Prescription();
            prescription.setId(rs.getInt("prescription_id"));
            prescription.setDoctorId(rs.getInt("doctor_id"));
            prescription.setDate(rs.getDate("prescription_date"));
            prescription.setDiagnosis(rs.getString("diagnosis"));
            prescription.setTreatment(rs.getString("treatment"));
            return prescription;
        }

    }

}

package com.medical.etl.reader;

import com.medical.etl.model.Patient;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientReader extends JdbcCursorItemReader<Patient> {

    final String sqlQuery = "SELECT patient_id,gender,weight,height,state,city,district " +
            "FROM patient JOIN address ON pincode=patient_pincode";

    public PatientReader(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.setSql(sqlQuery);
        this.setRowMapper(new PatientReader.PatientRowMapper());
    }

    private static class PatientRowMapper implements RowMapper<Patient> {

        @Override
        public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
            Patient patient = new Patient();
            patient.setId(rs.getInt("patient_id"));
            patient.setGender(rs.getString("gender"));
            patient.setWeight(rs.getDouble("weight"));
            patient.setHeight(rs.getDouble("height"));
            patient.setDistrict(rs.getString("district"));
            patient.setCity(rs.getString("city"));
            patient.setState(rs.getString("state"));
            return patient;
        }

    }

}

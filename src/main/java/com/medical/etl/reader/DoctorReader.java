package com.medical.etl.reader;

import com.medical.etl.model.Doctor;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorReader extends JdbcCursorItemReader<Doctor> {

    final String sqlQuery = "SELECT doctor_id,doctor_name,department,hospital_name,state,city,district,pincode " +
            "FROM doctor JOIN hospital USING(hospital_id) JOIN address ON pincode=hospital_pincode";

    public DoctorReader(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.setSql(sqlQuery);
        this.setRowMapper(new DoctorRowMapper());
    }

    private static class DoctorRowMapper implements RowMapper<Doctor> {

        @Override
        public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
            Doctor doctor = new Doctor();
            doctor.setId(rs.getInt("doctor_id"));
            doctor.setName(rs.getString("doctor_name"));
            doctor.setDepartment(rs.getString("department"));
            doctor.setHospital(rs.getString("hospital_name"));
            doctor.setPincode(rs.getInt("pincode"));
            doctor.setDistrict(rs.getString("district"));
            doctor.setCity(rs.getString("city"));
            doctor.setState(rs.getString("state"));
            return doctor;
        }

    }

}

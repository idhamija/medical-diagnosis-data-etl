package com.medical.etl.reader;

import com.medical.etl.model.Lab;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LabReader extends JdbcCursorItemReader<Lab> {

    final String sqlQuery = "SELECT lab_id,lab_name,state,city,district,pincode " +
            "FROM lab JOIN address ON pincode=lab_pincode";

    public LabReader(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.setSql(sqlQuery);
//        this.setCurrentItemCount(0);
        this.setRowMapper(new LabReader.LabRowMapper());
    }

    private static class LabRowMapper implements RowMapper<Lab> {

        @Override
        public Lab mapRow(ResultSet rs, int rowNum) throws SQLException {
            Lab lab = new Lab();
            lab.setId(rs.getInt("lab_id"));
            lab.setName(rs.getString("lab_name"));
            lab.setPincode(rs.getInt("pincode"));
            lab.setDistrict(rs.getString("district"));
            lab.setCity(rs.getString("city"));
            lab.setState(rs.getString("state"));
            return lab;
        }

    }

}

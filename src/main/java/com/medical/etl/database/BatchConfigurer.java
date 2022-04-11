package com.medical.etl.database;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class BatchConfigurer extends DefaultBatchConfigurer {

    @Autowired
    public BatchConfigurer(DataSource dataSource) {
        super(dataSource);
    }

}

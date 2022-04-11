package com.medical.etl.database;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatasourceManager {

    @Primary
    @Bean(name = "source")
    @ConfigurationProperties(prefix = "spring.source")
    public DataSource sourceDS() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "target")
    @ConfigurationProperties(prefix = "spring.target")
    public DataSource targetDS() {
        return DataSourceBuilder.create().build();
    }

}

package com.sebbia.batch.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataConfig {

    @Value("${database.driver}")
    String databaseDriver;

    @Value("${database.url}")
    String databaseUrl;

    @Value("${database.name}")
    String databaseName;

    @Value("${database.user}")
    String databaseUser;

    @Value("${database.pwd}")
    String databasePassword;

    @Value("${database.test-period}")
    int idleConnectionTestPeriod;

    @Bean(name="datаSource")
    public DataSource getDataSource() {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(databaseDriver);
            dataSource.setJdbcUrl(databaseUrl + databaseName);
            dataSource.setUser(databaseUser);
            dataSource.setPassword(databasePassword);
            dataSource.setIdleConnectionTestPeriod(idleConnectionTestPeriod);
            return dataSource;
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize database connection", e);
        }
    }
}

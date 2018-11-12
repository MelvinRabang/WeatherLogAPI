package com.weatherlog.app;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	private static final String TEMP_DIRECTORY = System.getProperty("java.io.tmpdir");
	
	@Bean(name = "mainDataSource")
	public DataSource createMainDataSource() {
		JdbcDataSource ds = new JdbcDataSource();
		ds.setURL("jdbc:h2:"+TEMP_DIRECTORY+"/testdata;MODE=MySQL");
		return ds;
	}
	
	@Bean(name = "secondaryDataSource")
	public DataSource createSecondaryDataSource() {
		JdbcDataSource ds = new JdbcDataSource();
		ds.setURL("jdbc:h2:"+TEMP_DIRECTORY+"/secondarydata;MODE=MySQL");
		return ds;
	}
}

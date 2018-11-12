package com.weatherlog.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sql.properties")
@ConfigurationProperties(prefix = "sql")
public class WeatherLogSqlConfigureProperties {

	private String getAllWeatherLogsQuery;
	
	public String getGetAllWeatherLogsQuery() {
		return getAllWeatherLogsQuery;
	}
	public void setGetAllWeatherLogsQuery(String getAllWeatherLogsQuery) {
		this.getAllWeatherLogsQuery = getAllWeatherLogsQuery;
	}
}

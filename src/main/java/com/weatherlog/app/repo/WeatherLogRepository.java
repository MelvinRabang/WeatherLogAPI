package com.weatherlog.app.repo;

import java.util.List;

import com.weatherlog.app.dto.WeatherLogDTO;

public interface WeatherLogRepository {

	public List<WeatherLogDTO> getAllWeatherLogs();
	
	public int saveWeatherLog();
	
	public int deleteWeatherLog();
}

package com.weatherlog.app.service.impl;

import org.springframework.stereotype.Service;

import com.weatherlog.app.dto.WeatherLogDTO;
import com.weatherlog.app.entity.WeatherLogClientEntity;
import com.weatherlog.app.service.WeatherLogService;

@Service
public class WeatherLogServiceImpl implements WeatherLogService{

	@Override
	public WeatherLogDTO convertWeatherLogEntitytoDTO(WeatherLogClientEntity weatherLogEntity) {
		WeatherLogDTO dto = new WeatherLogDTO();
		dto.setActualWeather(weatherLogEntity.getWeather().get(0).getDescription());
		return dto;
	}

}

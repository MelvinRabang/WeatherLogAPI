package com.weatherlog.app.service;

import com.weatherlog.app.dto.WeatherLogDTO;
import com.weatherlog.app.entity.WeatherLogClientEntity;

public interface WeatherLogService {

	public WeatherLogDTO convertWeatherLogEntitytoDTO(WeatherLogClientEntity weatherLogEntity);
}

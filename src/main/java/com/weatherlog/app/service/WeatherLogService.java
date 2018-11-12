package com.weatherlog.app.service;

import com.weatherlog.app.dto.WeatherLogDTO;
import com.weatherlog.app.entity.WeatherLogClientJsonDto;
//import com.weatherlog.app.entity.WeatherLogEntity;

public interface WeatherLogService {

	public WeatherLogDTO convertWeatherLogJsonToDTO(WeatherLogClientJsonDto weatherLogEntity);
	
//	public WeatherLogDTO storeWeatherLogResponse(WeatherLogEntity weatherLogEntity);
}

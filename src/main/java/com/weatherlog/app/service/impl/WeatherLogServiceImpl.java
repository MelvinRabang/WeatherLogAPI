package com.weatherlog.app.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.weatherlog.app.dto.WeatherLogDTO;
import com.weatherlog.app.entity.Weather;
import com.weatherlog.app.entity.WeatherLogClientEntity;
import com.weatherlog.app.service.WeatherLogService;

@Service
public class WeatherLogServiceImpl implements WeatherLogService{

	private final static String EMPTY_STRING = "";
	private final static String COMMA_SEPERATED_STRING = ", ";
	private final static Float KELVIN_TO_CELSIUS_CONVERTER = 273.15F;
	private final static String TWO_DECIMAL_PLACES_ROUND_FLOAT = "%.2f";
	private final static String DEGREES_CELSIUS = "° C";

	@Override
	public WeatherLogDTO convertWeatherLogEntitytoDTO(WeatherLogClientEntity weatherLogEntity) {
		WeatherLogDTO weatherLogDTO = new WeatherLogDTO();
		weatherLogDTO.setResponseId(generateUniqueGuid());
		weatherLogDTO.setTemperature(convertKelvinToCelsiusTemperature(weatherLogEntity.getMain().getTemp()));
		weatherLogDTO.setActualWeather(convertWeatherToCommaSeperatedString(weatherLogEntity.getWeather()));
		return weatherLogDTO;
	}

	private String convertWeatherToCommaSeperatedString(List<Weather> weatherList){
		String weatherDescription = EMPTY_STRING;
		if (weatherList != null) {
			if (weatherList.size() == 1) {
				weatherDescription = weatherList.get(0).getDescription();
			} else {
				for (Iterator<Weather> weatherListIterator = weatherList.iterator(); weatherListIterator.hasNext();) {
					weatherDescription += weatherListIterator.next().getDescription();
				    if (weatherListIterator.hasNext()) {
				    	weatherDescription += COMMA_SEPERATED_STRING;
				    }
				}
			}
		}
		return weatherDescription;
	}
	
	private String convertKelvinToCelsiusTemperature(String kelvinTemperature) {
		String celsiusTempString = EMPTY_STRING;
		if (kelvinTemperature != null) {
			Float kelvinTemp = Float.valueOf(kelvinTemperature);
			Float celsiusTemp = kelvinTemp - KELVIN_TO_CELSIUS_CONVERTER;
			celsiusTempString = String.format(TWO_DECIMAL_PLACES_ROUND_FLOAT, celsiusTemp);
			celsiusTempString += DEGREES_CELSIUS;
		}
		return celsiusTempString;
	}
	
	private String generateUniqueGuid() {
		UUID uuid = UUID.randomUUID();
	    String randomUUIDString = uuid.toString();
	    return randomUUIDString;
	}
}

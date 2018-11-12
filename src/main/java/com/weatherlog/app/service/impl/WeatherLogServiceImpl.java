package com.weatherlog.app.service.impl;

import java.time.Instant;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weatherlog.app.dto.WeatherLogDTO;
import com.weatherlog.app.entity.Weather;
import com.weatherlog.app.entity.WeatherLogClientJsonDto;
import com.weatherlog.app.repo.WeatherLogRepository;
import com.weatherlog.app.service.WeatherLogService;

@Service
public class WeatherLogServiceImpl implements WeatherLogService{

	private final static String EMPTY_STRING = "";
	private final static String COMMA_SEPERATED_STRING = ", ";
	private final static Float KELVIN_TO_CELSIUS_CONVERTER = 273.15F;
	private final static String TWO_DECIMAL_PLACES_ROUND_FLOAT = "%.2f";
	private final static String DEGREES_CELSIUS = "° C";
	
	@Autowired
    WeatherLogRepository weatherLogEntityRepository;

	@Override
	public WeatherLogDTO convertWeatherLogJsonToDTO(WeatherLogClientJsonDto weatherLogClientJson) {
		WeatherLogDTO weatherLogDto = new WeatherLogDTO();
		weatherLogDto.setResponseId(generateUniqueGuid());
		weatherLogDto.setTemperature(convertKelvinToCelsiusTemperature(weatherLogClientJson.getMain().getTemp()));
		weatherLogDto.setActualWeather(convertWeatherToCommaSeperatedString(weatherLogClientJson.getWeather()));
		weatherLogDto.setDtimeInserted(Instant.now());
		weatherLogDto.setLocation(weatherLogClientJson.getLocation());
		return weatherLogDto;
	}

//	@Override
//	public WeatherLogDTO storeWeatherLogResponse(WeatherLogEntity weatherLogEntity) {
//		WeatherLogDTO finalDto = new WeatherLogDTO();
//		List<WeatherLogDTO> weatherLogs = weatherLogEntityRepository.getAllWeatherLogs();
//		if (weatherLogs.size() >= 5) {
//			int deleteWeatherLogEntityId = extractEarliestTimeStampWeatherLogID(weatherLogs);
//			deleteWeatherLog(deleteWeatherLogEntityId);
//		}
//		weatherLogEntityRepository.save(weatherLogEntity);
//		finalDto = convertEntityToDto(weatherLogEntity);
//		return finalDto;
//	}

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

//	private WeatherLogDTO convertEntityToDto(WeatherLogEntity weatherLogEntity) {
//		WeatherLogDTO finalDto = new WeatherLogDTO();
//		finalDto.setId(weatherLogEntity.getId());
//		finalDto.setActualWeather(weatherLogEntity.getActualWeather());
//		finalDto.setDtimeInserted(weatherLogEntity.getDtimeInserted());
//		finalDto.setLocation(weatherLogEntity.getLocation());
//		finalDto.setTemperature(weatherLogEntity.getTemperature());
//		finalDto.setResponseId(weatherLogEntity.getResponseId());
//		return finalDto;
//	}
	
//	private int extractEarliestTimeStampWeatherLogID(List<WeatherLogEntity> weatherLogs) {
//		int finalId = 0;
//		if (weatherLogs != null) {
//			WeatherLogEntity entityToBeCompared = weatherLogs.get(0);
//			for (WeatherLogEntity weatherLogEntity : weatherLogs) {
//				if (entityToBeCompared.getDtimeInserted().compareTo(weatherLogEntity.getDtimeInserted()) < 1) {
//					entityToBeCompared = weatherLogEntity;
//				}
//			}
//			finalId = (int) entityToBeCompared.getId();
//		}
//		
//		return finalId;
//	}
}
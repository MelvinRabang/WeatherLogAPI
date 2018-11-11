package com.weatherlog.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.weatherlog.app.dto.WeatherLogDTO;
import com.weatherlog.app.entity.WeatherLogClientEntity;
import com.weatherlog.app.service.WeatherLogService;

@CrossOrigin
@RestController
@RequestMapping("/api/weatherlog")
public class WeatherLogApiController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WeatherLogService weatherLogService;

	@Value("${openWeatherMapClient.url}")
	private String clientURL;
	
	@Value("${openWeatherMapClient.apiKey}")
	private String apiKey;

	private static final String LOCATION_CLIENT_PARAM = "?q=";
	private final String AND_CHAR = "&";

	@GetMapping()
	public WeatherLogDTO getURLAvailability(@RequestParam(name="location") String location) {
		String finalUrl = extractClientUrl(location);
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		WeatherLogClientEntity weatherLogClientEntity = restTemplate.getForObject(finalUrl, WeatherLogClientEntity.class);
		WeatherLogDTO weatherLogDto = (WeatherLogDTO) weatherLogService.convertWeatherLogEntitytoDTO(weatherLogClientEntity);
		return weatherLogDto;
	}
	
	private String extractClientUrl(String location) {
		return clientURL + LOCATION_CLIENT_PARAM + location  + AND_CHAR + apiKey;
	}
}
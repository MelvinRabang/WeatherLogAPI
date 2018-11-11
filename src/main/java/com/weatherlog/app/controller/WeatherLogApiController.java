package com.weatherlog.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
@RequestMapping("/api/weatherlog")
public class WeatherLogApiController {

	@Autowired
	private RestTemplate restTemplate;
	 
	@Value("${openWeatherMapClient.url}")
	private String clientURL;
	
	@Value("${openWeatherMapClient.apiKey}")
	private String apiKey;

	private static final String LOCATION_CLIENT_PARAM = "?q=";
	private final String AND_CHAR = "&";

	@GetMapping()
	String getURLAvailability(@RequestParam(name="location") String location) {
		String finalUrl = extractClientUrl(location);
		System.out.println("finalUrl" + finalUrl);
		return restTemplate.getForObject(finalUrl, String.class);
	}
	
	private String extractClientUrl(String location) {
		return clientURL + LOCATION_CLIENT_PARAM + location  + AND_CHAR + apiKey;
	}
}
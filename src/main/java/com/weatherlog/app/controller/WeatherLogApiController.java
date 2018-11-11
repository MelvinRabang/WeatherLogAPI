package com.weatherlog.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/weatherlog")
public class WeatherLogApiController {

	@Autowired
	RestTemplate restTemplate;
	 
	 
	@Value("${operations.restURL}")
	String serviceURL;
	 
	@GetMapping()
	String getURLAvailability() {
		return restTemplate.getForObject(serviceURL, String.class);
	}
	
}
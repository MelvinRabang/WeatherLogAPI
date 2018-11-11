package com.weatherlog.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = {"com.weatherlog.app", "scom.weatherlog.app.*"})
@SpringBootApplication
public class WeatherLogAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherLogAPIApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}

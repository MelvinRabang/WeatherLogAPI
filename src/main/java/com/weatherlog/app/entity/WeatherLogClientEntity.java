package com.weatherlog.app.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherLogClientEntity {

	@JsonProperty("weather")
	private List<Weather> weather = new ArrayList<Weather>();

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	
}

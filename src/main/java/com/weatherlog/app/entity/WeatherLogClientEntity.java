package com.weatherlog.app.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherLogClientEntity {

	@JsonProperty("weather")
	private List<Weather> weather = new ArrayList<Weather>();

	@JsonProperty("main")
	private MainTemperature main;

	public List<Weather> getWeather() {
		return weather;
	}

	public MainTemperature getMain() {
		return main;
	}
}

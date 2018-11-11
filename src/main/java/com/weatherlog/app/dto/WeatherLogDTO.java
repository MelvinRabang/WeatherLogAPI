package com.weatherlog.app.dto;

public class WeatherLogDTO {

	private long id;
	private String responseId;
	private String location;
	private String actualWeather;
	private String temperature;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getResponseId() {
		return responseId;
	}
	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getActualWeather() {
		return actualWeather;
	}
	public void setActualWeather(String actualWeather) {
		this.actualWeather = actualWeather;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
}

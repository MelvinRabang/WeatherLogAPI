package com.weatherlog.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MainTemperature {

	@JsonProperty("temp")
	private String temp;
	
	public String getTemp() {
		return temp;
	}

}

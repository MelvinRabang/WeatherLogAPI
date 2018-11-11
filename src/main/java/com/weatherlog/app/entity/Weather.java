package com.weatherlog.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {

	@JsonProperty("description")
	private String description;
	
	public String getDescription() {
		return description;
	}
}

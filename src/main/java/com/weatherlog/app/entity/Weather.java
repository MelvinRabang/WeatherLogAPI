package com.weatherlog.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {

	@JsonProperty("description")
	private String description;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("main")
	private String main;
	
	@JsonProperty("icon")
	private String icon;

	public String getDescription() {
		return description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

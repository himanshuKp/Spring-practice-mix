package com.himanshu.weatherapi.common;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HourlyWeatherListDTO {

	private String location;
	
	@JsonProperty("hourly_forecast")
	private List<HourlyWeatherDTO> hourlyWeatherDTO = new ArrayList<>();
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<HourlyWeatherDTO> getHourlyWeatherDTO() {
		return hourlyWeatherDTO;
	}
	public void setHourlyWeatherDTO(List<HourlyWeatherDTO> hourlyWeatherDTO) {
		this.hourlyWeatherDTO = hourlyWeatherDTO;
	}
	
	public void addHourlyWeatherDTO(HourlyWeatherDTO hourlyWeatherDTO) {
		this.hourlyWeatherDTO.add(hourlyWeatherDTO);
	}
}

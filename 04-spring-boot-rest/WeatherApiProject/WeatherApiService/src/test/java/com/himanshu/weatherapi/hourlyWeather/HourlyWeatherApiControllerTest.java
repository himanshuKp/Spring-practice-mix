package com.himanshu.weatherapi.hourlyWeather;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.himanshu.weatherapi.GeolocationException;
import com.himanshu.weatherapi.GeolocationService;
import com.himanshu.weatherapi.common.HourlyWeather;
import com.himanshu.weatherapi.common.HourlyWeatherDTO;
import com.himanshu.weatherapi.common.Location;
import com.himanshu.weatherapi.location.LocationDataNotFoundException;

@WebMvcTest(HourlyWeatherApiController.class)
public class HourlyWeatherApiControllerTest {
	private static final String END_POINT_PATH = "/v1/hourly";
	private static final String X_CURRENT_HOUR = "X-Current-Hour";
	
	@Autowired MockMvc mockMvc;
	@Autowired private ObjectMapper objectMapper;
	
	@MockitoBean private HourlyWeatherService hourlyWeatherService;
	@MockitoBean private GeolocationService geolocationService;
	
	@Test
	public void testGetByIPShouldReturn400BadRequestBecauseNoHeaderXCurrentHour() throws Exception {
		mockMvc.perform(get(END_POINT_PATH))
						.andExpect(status().isBadRequest())
						.andDo(print());
	}
	
	@Test
	public void testGetByIPShouldReturn400BadRequestBecauseGeolocationException() throws Exception {
		when(geolocationService.getLocation(anyString())).thenThrow(GeolocationException.class);
		
		mockMvc.perform(get(END_POINT_PATH).header(X_CURRENT_HOUR, "9"))
						.andExpect(status().isBadRequest())
						.andDo(print());
	}
	
	@Test
	public void testGetByIPShouldReturn204NoContent() throws Exception {
		int currentHour = 9;
		Location location = new Location().locationCode("DELHI_IND");
		
		
		when(geolocationService.getLocation(anyString())).thenReturn(location);
		when(hourlyWeatherService.getByLocation(location, currentHour)).thenThrow(LocationDataNotFoundException.class);
		
		mockMvc.perform(get(END_POINT_PATH).header(X_CURRENT_HOUR, currentHour))
		.andExpect(status().isNotFound())
		.andDo(print());
	}
	
	@Test
	public void testGetByIPShouldReturn200OK() throws Exception {
		int currentHour = 9;
		
		Location location = new Location();
		location.setCode("NYC_USA");
		location.setCityName("New York City");
		location.setRegionName("New York");
		location.setCountryCode("US");
		location.setCountryName("United States of America");
		
		HourlyWeather forecast1 = new HourlyWeather()
				.location(location)
				.hourOfDay(10)
				.temperature(13)
				.precipitation(70)
				.status("Cloudy");		
		
		HourlyWeather forecast2 = new HourlyWeather()
				.location(location)
				.hourOfDay(11)
				.temperature(15)
				.precipitation(60)
				.status("Sunny");		
		
		when(geolocationService.getLocation(anyString())).thenReturn(location);
		when(hourlyWeatherService.getByLocation(location, currentHour)).thenReturn(List.of(forecast1, forecast2));
		
		String expectedPath = location.toString();
		
		mockMvc.perform(get(END_POINT_PATH).header(X_CURRENT_HOUR, currentHour))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.location", is(expectedPath)))
		.andExpect(jsonPath("$.hourly_forecast[0].hour_of_day", is(10)))
		.andDo(print());		
	}
	
	@Test
	public void testGetByCodeShouldReturn400BadRequest() throws Exception {
		mockMvc.perform(get(END_POINT_PATH+"/DELHI_IND").header(X_CURRENT_HOUR, "as"))
					.andExpect(status().isBadRequest())
					.andDo(print());
	}
	
	@Test
	public void testGetByCodeShouldReturn404NotFound() throws Exception {
		String locationCode = "DELHI_IND";
		int currentHour = 9;
		
		when(hourlyWeatherService.getByLocationCode(locationCode, currentHour)).thenThrow(LocationDataNotFoundException.class);
		
		mockMvc.perform(get(END_POINT_PATH+"/"+locationCode).header(X_CURRENT_HOUR, currentHour))
		.andExpect(status().isNotFound())
		.andDo(print());
	}
	
	@Test
	public void testGetByCodeShouldReturn204NoContent() throws Exception {
		String locationCode = "DELHI_IND";
		int currentHour = 9;
		String requestUri = END_POINT_PATH+"/"+locationCode;
		
		when(hourlyWeatherService.getByLocationCode(locationCode, currentHour)).thenReturn(Collections.emptyList());
		
		mockMvc.perform(get(requestUri).header(X_CURRENT_HOUR, currentHour))
		.andExpect(status().isNoContent())
		.andDo(print());
	}
	
	@Test
	public void testGetByCodeShouldReturn200Ok() throws Exception {
		String locationCode = "NEW_YORK";
		int currentHour = 9;
		String requestUri = END_POINT_PATH+"/"+locationCode;
		
		Location location = new Location();
		location.setCode(locationCode);
		location.setCityName("New York City");
		location.setRegionName("New York");
		location.setCountryCode("US");
		location.setCountryName("United States of America");
		
		HourlyWeather forecast1 = new HourlyWeather()
				.location(location)
				.hourOfDay(10)
				.temperature(13)
				.precipitation(70)
				.status("Cloudy");		
		
		HourlyWeather forecast2 = new HourlyWeather()
				.location(location)
				.hourOfDay(11)
				.temperature(15)
				.precipitation(60)
				.status("Sunny");		
		
		when(hourlyWeatherService.getByLocationCode(locationCode, currentHour)).thenReturn(List.of(forecast1, forecast2));
		
		String expectedPath = location.toString();
		
		mockMvc.perform(get(requestUri).header(X_CURRENT_HOUR, currentHour))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.location", is(expectedPath)))
		.andDo(print());
	}

	@Test
	public void testUpdateWeatherService404BadRequestNoData() throws Exception {
		String locationCode = "NEW_YORK";
		String requestUri = END_POINT_PATH+"/"+locationCode;
		
		 List<HourlyWeatherDTO> hourlyWeatherDTOs = Collections.emptyList();
		 
		 String requestBodyDTO = objectMapper.writeValueAsString(hourlyWeatherDTOs);
		 
		 mockMvc.perform(put(requestUri).contentType(MediaType.APPLICATION_JSON).content(requestBodyDTO))
		 .andExpect(status().isBadRequest())
		 .andDo(print());
	}
}

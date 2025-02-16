package com.himanshu.weatherapi.realtime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.himanshu.weatherapi.common.Location;
import com.himanshu.weatherapi.common.RealtimeWeather;
import com.himanshu.weatherapi.location.LocationDataNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.is;

import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

@WebMvcTest(RealtimeWeatherApiController.class)
public class RealtimeWeatherApiControllerTest {

    private static final String API_URL = "/v1/realtime";

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    private RealtimeWeatherService realtimeWeatherService;
    @MockitoBean
    private GeolocationService geolocationService;

    @Test
    public void testGetShouldReturn400BadRequest() throws Exception {
        Mockito.when(geolocationService.getLocation(Mockito.anyString())).thenThrow(GeolocationException.class);

        mockMvc.perform(get(API_URL))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    public void testGetShouldReturn404NotFound() throws Exception {
        Location location = new Location();
        Mockito.when(geolocationService.getLocation(Mockito.anyString())).thenReturn(location);
        Mockito.when(realtimeWeatherService.getRealtimeWeatherByLocation(location)).thenThrow(LocationDataNotFoundException.class);

        mockMvc.perform(get(API_URL))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    public void testGetShouldReturn200Ok() throws Exception {
        Location location = new Location();
        location.setCode("DELHI_IND");
        location.setRegionName("Delhi");
        location.setCountryCode("IN");
        location.setCountryName("India");
        location.setEnabled(true);

        RealtimeWeather realtimeWeather = new RealtimeWeather();
        realtimeWeather.setPrecipitation(33);
        realtimeWeather.setTemperature(27);
        realtimeWeather.setHumidity(29);
        realtimeWeather.setWindSpeed(22);
        realtimeWeather.setLastUpdated(new Date());
        realtimeWeather.setStatus("Windy");

        realtimeWeather.setLocation(location);
        location.setRealtimeWeather(realtimeWeather);

        Mockito.when(geolocationService.getLocation(Mockito.anyString())).thenReturn(location);
        Mockito.when(realtimeWeatherService.getRealtimeWeatherByLocation(location)).thenReturn(realtimeWeather);

        mockMvc.perform(get(API_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }
}

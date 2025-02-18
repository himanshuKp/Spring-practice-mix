package com.himanshu.weatherapi.realtime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.himanshu.weatherapi.GeolocationException;
import com.himanshu.weatherapi.GeolocationService;
import com.himanshu.weatherapi.common.Location;
import com.himanshu.weatherapi.common.RealtimeWeather;
import com.himanshu.weatherapi.dto.RealtimeWeatherDTO;
import com.himanshu.weatherapi.location.LocationDataNotFoundException;
import org.apiguardian.api.API;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
        location.setCode("SFCA_USA");
        location.setCityName("San Franciso");
        location.setRegionName("California");
        location.setCountryName("United States of America");
        location.setCountryCode("US");

        RealtimeWeather realtimeWeather = new RealtimeWeather();
        realtimeWeather.setTemperature(12);
        realtimeWeather.setHumidity(32);
        realtimeWeather.setLastUpdated(new Date());
        realtimeWeather.setPrecipitation(88);
        realtimeWeather.setStatus("Cloudy");
        realtimeWeather.setWindSpeed(5);

        realtimeWeather.setLocation(location);
        location.setRealtimeWeather(realtimeWeather);

        Mockito.when(geolocationService.getLocation(Mockito.anyString())).thenReturn(location);
        Mockito.when(realtimeWeatherService.getRealtimeWeatherByLocation(location)).thenReturn(realtimeWeather);

        mockMvc.perform(get(API_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    public void testGetByLocationCodeShouldReturnStatus404NotFound() throws Exception {
        String locationCode = "SFCA_USA";
        Mockito.when(realtimeWeatherService.getRealtimeByLocationCode(locationCode)).thenThrow(LocationDataNotFoundException.class);

        String URL_PATH = API_URL + "/" + locationCode;

        mockMvc.perform(get(URL_PATH))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    public void testGetByLocationCodeShouldReturn200Ok() throws Exception {
        Location location = new Location();
        location.setCode("SFCA_USA");
        location.setCityName("San Franciso");
        location.setRegionName("California");
        location.setCountryName("United States of America");
        location.setCountryCode("US");
        RealtimeWeather realtimeWeather = new RealtimeWeather();
        realtimeWeather.setTemperature(12);
        realtimeWeather.setHumidity(32);
        realtimeWeather.setLastUpdated(new Date());
        realtimeWeather.setPrecipitation(88);
        realtimeWeather.setStatus("Cloudy");
        realtimeWeather.setWindSpeed(5);
        realtimeWeather.setLocation(location);
        location.setRealtimeWeather(realtimeWeather);

        Mockito.when(geolocationService.getLocation(Mockito.anyString())).thenReturn(location);
        Mockito.when(realtimeWeatherService.getRealtimeByLocationCode(location.getCode())).thenReturn(realtimeWeather);

        String URL_PATH = API_URL + "/" + location.getCode();
        mockMvc.perform(get(URL_PATH))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    public void updateRealtimeWeatherByLocationCodeAndRealtimeDTOShouldReturn404NotFound() throws Exception {
        String locationCode = "ABC_USA";
        RealtimeWeather realtimeWeather = new RealtimeWeather();
        realtimeWeather.setTemperature(12);
        realtimeWeather.setHumidity(32);
        realtimeWeather.setPrecipitation(88);
        realtimeWeather.setStatus("Cloudy");
        realtimeWeather.setWindSpeed(5);

        String bodyContent = objectMapper.writeValueAsString(realtimeWeather);

        Mockito.when(realtimeWeatherService.updateRealtimeWeather(Mockito.eq(locationCode), Mockito.any())).thenThrow(LocationDataNotFoundException.class);
        String URL_PATH = API_URL + "/" + locationCode;

        mockMvc.perform(put(URL_PATH).contentType(MediaType.APPLICATION_JSON).content(bodyContent))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    public void updateRealtimeWeatherByLocationCodeAndRealtimeDTOShouldReturn200Ok() throws Exception {
        String locationCode = "MUMBAI_IND";
        RealtimeWeather realtimeWeather = new RealtimeWeather();
        realtimeWeather.setTemperature(12);
        realtimeWeather.setHumidity(32);
        realtimeWeather.setPrecipitation(88);
        realtimeWeather.setStatus("Cloudy");
        realtimeWeather.setWindSpeed(5);
        realtimeWeather.setLastUpdated(new Date());

        RealtimeWeatherDTO dto = new RealtimeWeatherDTO();
        dto.setTemperature(12);
        dto.setHumidity(32);
        dto.setPrecipitation(88);
        dto.setStatus("Cloudy");
        dto.setWindSpeed(5);

        Location location = new Location();
        location.setCode(locationCode);
        location.setCityName("San Franciso");
        location.setRegionName("California");
        location.setCountryName("United States of America");
        location.setCountryCode("US");

        realtimeWeather.setLocation(location);
        location.setRealtimeWeather(realtimeWeather);

        Mockito.when(realtimeWeatherService.updateRealtimeWeather(locationCode, realtimeWeather)).thenReturn(realtimeWeather);

        String bodyContent = objectMapper.writeValueAsString(dto);

        String URL_PATH = API_URL + "/" + locationCode;

        mockMvc.perform(put(URL_PATH).contentType(MediaType.APPLICATION_JSON).content(bodyContent))
                .andExpect(status().isOk())
                .andDo(print());
    }
}

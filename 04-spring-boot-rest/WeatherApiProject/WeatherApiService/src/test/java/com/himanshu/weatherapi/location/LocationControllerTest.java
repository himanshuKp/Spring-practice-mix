package com.himanshu.weatherapi.location;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.himanshu.weatherapi.common.Location;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LocationController.class)
public class LocationControllerTest {
    private static final String END_URI = "/v1/locations";

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper mapper;
    @MockitoBean LocationService locationService;

    @Test
    public void testShouldReturn400BadRequest() throws Exception {
        Location location = new Location();
        String bodyContent = mapper.writeValueAsString(location);

        mockMvc.perform(post(END_URI).contentType(MediaType.APPLICATION_JSON).content(bodyContent))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    public void testShouldReturn201Created() throws Exception {
        Location location = new Location();
        location.setCode("NYC_USA");
        location.setCityName("New York");
        location.setCountryCode("US");
        location.setCountryName("United States");
        location.setRegionName("New York");
        location.setEnabled(true);

        Mockito.when(locationService.addLocation(location)).thenReturn(location);

        String bodyContent = mapper.writeValueAsString(location);

        mockMvc.perform(post(END_URI).contentType(MediaType.APPLICATION_JSON).content(bodyContent))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code", is("NYC_USA")))
                .andExpect(header().string("Location", is("/v1/locations/NYC_USA")))
                .andDo(print());
    }

    @Test
    public void testShouldReturn204NoContent() throws Exception {
        Mockito.when(locationService.getAllUntarnishedLocations()).thenReturn(Collections.emptyList());

        mockMvc.perform(get(END_URI))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    @Test
    public void testShouldReturn200Ok() throws Exception {
        Location location1 = new Location();
        location1.setCode("NYC_USA");
        location1.setCityName("New York");
        location1.setCountryCode("US");
        location1.setCountryName("United States");
        location1.setRegionName("New York");
        location1.setEnabled(true);

        Location location2 = new Location();
        location2.setCode("LACA_USA");
        location2.setCityName("Los Angeles");
        location2.setCountryCode("US");
        location2.setCountryName("California");
        location2.setRegionName("Los Angeles");
        location2.setEnabled(true);

        Mockito.when(locationService.getAllUntarnishedLocations()).thenReturn(List.of(location1, location2));

        mockMvc.perform(get(END_URI))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].code", is("NYC_USA")))
                .andExpect(jsonPath("$[0].city_name", is("New York")))
                .andExpect(jsonPath("$[1].code", is("LACA_USA")))
                .andExpect(jsonPath("$[1].city_name", is("Los Angeles")))
                .andDo(print());
    }

    @Test
    public void testShouldReturn200FoundData() throws Exception {
        String REQUEST_URI = "/v1/locations/NYC_USA";

        Location location = new Location();
        location.setCode("NYC_USA");
        location.setCityName("New York");
        location.setCountryCode("US");
        location.setCountryName("United States");
        location.setRegionName("New York");
        location.setEnabled(true);

        Mockito.when(locationService.getLocationByCode("NYC_USA")).thenReturn(location);

        mockMvc.perform(get(REQUEST_URI))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code", is("NYC_USA")))
                .andExpect(jsonPath("$.city_name", is("New York")))
                .andDo(print());
    }

    @Test
    public void testShouldReturn204NoContentByCode() throws Exception {
        String REQUEST_URI = "/v1/locations/NYC_USA";
        Mockito.when(locationService.getLocationByCode("NYC_USA")).thenReturn(null);
        mockMvc.perform(get(REQUEST_URI))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    @Test
    public void testUpdateShouldReturn200Ok() throws Exception {
        Location location = new Location();
        location.setCode("NYC_USA");
        location.setCityName("New York");
        location.setCountryCode("US");
        location.setCountryName("United States of America");
        location.setRegionName("New York");
        location.setEnabled(true);

        Mockito.when(locationService.updateLocation(location)).thenReturn(location);

        mockMvc.perform(put(END_URI).contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(location)))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andDo(print());
    }

    @Test
    public void testUpdateShouldReturn404NoContent() throws Exception {
        Location location = new Location();
        location.setCode("NYC_USA");
        location.setCityName("New York");
        location.setCountryCode("US");
        location.setCountryName("United States of America");
        location.setRegionName("New York");
        location.setEnabled(true);

        Mockito.when(locationService.updateLocation(location)).thenThrow(new LocationDataNotFoundException("No content found"));

        mockMvc.perform(put(END_URI).contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(location)))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    public void testDeleteShouldReturn404Ok() throws Exception {
        String REQUEST_URI = "/v1/locations/NYC_USA";

        Mockito.doThrow(LocationDataNotFoundException.class).when(locationService).deleteLocation("NYC_USA");

        mockMvc.perform(delete(REQUEST_URI))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    public void testDeleteShouldReturn204NoContent() throws Exception {
        String REQUEST_URI = "/v1/locations/NYC_USA";

        Mockito.doNothing().when(locationService).deleteLocation("NYC_USA");

        mockMvc.perform(delete(REQUEST_URI))
                .andExpect(status().isNoContent())
                .andDo(print());
    }
}

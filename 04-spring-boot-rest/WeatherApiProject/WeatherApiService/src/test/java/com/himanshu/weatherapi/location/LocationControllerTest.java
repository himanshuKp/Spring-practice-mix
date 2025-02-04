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

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
}

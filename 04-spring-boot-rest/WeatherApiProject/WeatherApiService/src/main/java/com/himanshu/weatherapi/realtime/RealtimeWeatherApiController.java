package com.himanshu.weatherapi.realtime;

import com.himanshu.weatherapi.GeolocationException;
import com.himanshu.weatherapi.GeolocationService;
import com.himanshu.weatherapi.common.Location;
import com.himanshu.weatherapi.common.RealtimeWeather;
import com.himanshu.weatherapi.dto.RealtimeWeatherDTO;
import com.himanshu.weatherapi.location.LocationDataNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/realtime")
public class RealtimeWeatherApiController {
    private final Logger LOGGER = LoggerFactory.getLogger(RealtimeWeatherApiController.class);

    private final RealtimeWeatherService realtimeWeatherService;
    private final GeolocationService locationService;
    private final ModelMapper modelMapper;

    public RealtimeWeatherApiController(RealtimeWeatherService realtimeWeatherService, GeolocationService locationService, ModelMapper modelMapper) {
        this.realtimeWeatherService = realtimeWeatherService;
        this.locationService = locationService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<?> getRealtimeWeather(HttpServletRequest request) {
        String ipAddress = CommonUtility.getIpAddress(request);

        try {
            Location locationById = locationService.getLocation(ipAddress);
            RealtimeWeather realtimeWeather = realtimeWeatherService.getRealtimeWeatherByLocation(locationById);

            RealtimeWeatherDTO weatherDTO = modelMapper.map(realtimeWeather, RealtimeWeatherDTO.class);
            return ResponseEntity.ok(weatherDTO);
        } catch (GeolocationException ex) {
            LOGGER.error(ex.getMessage(), ex);
            return ResponseEntity.badRequest().build();
        } catch (LocationDataNotFoundException ex) {
            LOGGER.error(ex.getMessage(), ex);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{locationCode}")
    public ResponseEntity<?> getRealtimeByLocationCode(@PathVariable("locationCode") String locationCode) {
        try {
            RealtimeWeather realtimeWeather = realtimeWeatherService.getRealtimeByLocationCode(locationCode);
            RealtimeWeatherDTO weatherDTO = getRealtimeWeatherDTO(realtimeWeather);
            return ResponseEntity.ok(weatherDTO);
        } catch (LocationDataNotFoundException ex) {
            LOGGER.error(ex.getMessage(), ex);
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{locationCode}")
    public ResponseEntity<?> updateRealtimeWeather(@PathVariable("locationCode") String locationCode,
                                                   @RequestBody @Valid RealtimeWeather realtimeWeather) {
        realtimeWeather.setLocationCode(locationCode);
        try {
            RealtimeWeather updatedRealtimeWeather = realtimeWeatherService.updateRealtimeWeather(locationCode, realtimeWeather);
            RealtimeWeatherDTO weatherDTO = getRealtimeWeatherDTO(updatedRealtimeWeather);
            return ResponseEntity.ok(weatherDTO);
        } catch (LocationDataNotFoundException ex) {
            LOGGER.error(ex.getMessage(), ex);
            return ResponseEntity.notFound().build();
        }
    }

    private RealtimeWeather getDTOToEntity(RealtimeWeatherDTO realtimeWeatherDTO) {
        return modelMapper.map(realtimeWeatherDTO, RealtimeWeather.class);
    }

    private RealtimeWeatherDTO getRealtimeWeatherDTO(RealtimeWeather realtimeWeather) {
        return modelMapper.map(realtimeWeather, RealtimeWeatherDTO.class);
    }
}

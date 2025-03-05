package com.himanshu.weatherapi.hourlyWeather;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.himanshu.weatherapi.GeolocationException;
import com.himanshu.weatherapi.GeolocationService;
import com.himanshu.weatherapi.common.HourlyWeather;
import com.himanshu.weatherapi.common.HourlyWeatherDTO;
import com.himanshu.weatherapi.common.HourlyWeatherListDTO;
import com.himanshu.weatherapi.common.Location;
import com.himanshu.weatherapi.location.LocationDataNotFoundException;
import com.himanshu.weatherapi.realtime.CommonUtility;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1/hourly")
public class HourlyWeatherApiController {

	private HourlyWeatherService hourlyWeatherService;
	private GeolocationService geolocationService;
	private ModelMapper modelMapper;
	
	public HourlyWeatherApiController(HourlyWeatherService hourlyWeatherService,	GeolocationService geolocationService, ModelMapper modelMapper) {
		super();
		this.hourlyWeatherService = hourlyWeatherService;
		this.geolocationService = geolocationService;
		this.modelMapper = modelMapper;
	}
	
	@GetMapping
	public ResponseEntity<?> listHourlyForecastByIpAddress(HttpServletRequest request){
		String ipAddress = CommonUtility.getIpAddress(request);
		
		try {
			int currentHour = Integer.parseInt(request.getHeader("X-Current-Hour"));
			
			Location locationFromIp = geolocationService.getLocation(ipAddress);
			
			List<HourlyWeather> hourlyForecast = hourlyWeatherService.getByLocation(locationFromIp, currentHour);
			
			if(hourlyForecast.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			
			return ResponseEntity.ok(listEntityToDTO(hourlyForecast));
		} catch (NumberFormatException | GeolocationException e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().build();
		} catch (LocationDataNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{location}")
	public ResponseEntity<?> listHourlyForecastByLocationCode(@PathVariable("location") String locationCode, HttpServletRequest request){
		try {
			int currentHour = Integer.parseInt(request.getHeader("X-Current-Hour"));
			
			List<HourlyWeather> hourlyForecast = hourlyWeatherService.getByLocationCode(locationCode, currentHour);
			
			if(hourlyForecast.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			
			return ResponseEntity.ok(listEntityToDTO(hourlyForecast));
		} catch (NumberFormatException e) {
			return ResponseEntity.badRequest().build();
		} catch (LocationDataNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	public HourlyWeatherListDTO listEntityToDTO(List<HourlyWeather> hourlyWeathers) {
		Location location = hourlyWeathers.get(0).getHourlyWeatherId().getLocation();
		
		HourlyWeatherListDTO hourlyWeatherListDTO = new HourlyWeatherListDTO();
		hourlyWeatherListDTO.setLocation(location.toString());
		
		hourlyWeathers.forEach(hourlyWeather -> {
			HourlyWeatherDTO dto = modelMapper.map(hourlyWeather, HourlyWeatherDTO.class);
			hourlyWeatherListDTO.addHourlyWeatherDTO(dto);
		});
		
		return hourlyWeatherListDTO;
	}
	
}

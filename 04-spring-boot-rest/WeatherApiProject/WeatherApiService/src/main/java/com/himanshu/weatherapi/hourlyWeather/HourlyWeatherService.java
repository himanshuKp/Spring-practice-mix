package com.himanshu.weatherapi.hourlyWeather;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.himanshu.weatherapi.common.HourlyWeather;
import com.himanshu.weatherapi.common.Location;
import com.himanshu.weatherapi.location.LocationDataNotFoundException;
import com.himanshu.weatherapi.location.LocationRepository;

@Service
public class HourlyWeatherService {
	
	private HourlyWeatherRepsitory hourlyWeatherRepsitory;
	private LocationRepository locationRepository;
	
	public HourlyWeatherService(HourlyWeatherRepsitory hourlyWeatherRepsitory, LocationRepository locationRepository) {
		super();
		this.hourlyWeatherRepsitory = hourlyWeatherRepsitory;
		this.locationRepository = locationRepository;
	}
	
	public List<HourlyWeather> getByLocation(Location location, int hourOfDay) {
		String countryCode = location.getCountryCode();
		String cityName =  location.getCityName();
		
		Location locationInDB = locationRepository.findByCountryCodeAndCityName(countryCode, cityName);
		
		if(locationInDB == null) {
			throw new LocationDataNotFoundException("No location found with the given country code and city name");
		}
		
		return  hourlyWeatherRepsitory.findByLocationCode(locationInDB.getCode(), hourOfDay);
	}
	
	public List<HourlyWeather> getByLocationCode(String code, int hourOfDay){
		Location locationInDB = locationRepository.findByLocationCode(code);
		
		if(locationInDB==null) {
			throw new LocationDataNotFoundException("No location found with the given location code");
		}
		
		return hourlyWeatherRepsitory.findByLocationCode(code, hourOfDay);
	}
	
	public List<HourlyWeather> updateHourlyWeatherData(String locationCode, List<HourlyWeather> hourlyWeathers){
		return Collections.emptyList();
	}
}

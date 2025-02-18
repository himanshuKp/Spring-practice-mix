package com.himanshu.weatherapi.realtime;

import com.himanshu.weatherapi.common.Location;
import com.himanshu.weatherapi.common.RealtimeWeather;
import com.himanshu.weatherapi.location.LocationDataNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RealtimeWeatherService {

    private final RealtimeWeatherRepository realtimeWeatherRepository;

    public RealtimeWeatherService(RealtimeWeatherRepository realtimeWeatherRepository) {
        this.realtimeWeatherRepository = realtimeWeatherRepository;
    }

    public RealtimeWeather getRealtimeWeatherByLocation(Location location) {
        String countryCode = location.getCountryCode();
        String cityName = location.getCityName();

        RealtimeWeather realtimeWeather = realtimeWeatherRepository.findByCityNameAndCountryCode(cityName, countryCode);
        if (realtimeWeather == null) {
            throw new LocationDataNotFoundException("No location data found for " + cityName + " " + countryCode);
        }
        return realtimeWeather;
    }

    public RealtimeWeather getRealtimeByLocationCode(String locationCode) {
        RealtimeWeather realtimeWeather = realtimeWeatherRepository.findByLocationCode(locationCode);
        if (realtimeWeather == null) {
            throw new LocationDataNotFoundException("No location data found for " + locationCode);
        }
        return realtimeWeather;
    }
}

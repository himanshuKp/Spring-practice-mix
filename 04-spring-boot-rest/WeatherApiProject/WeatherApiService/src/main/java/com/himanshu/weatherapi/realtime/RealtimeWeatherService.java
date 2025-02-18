package com.himanshu.weatherapi.realtime;

import com.himanshu.weatherapi.common.Location;
import com.himanshu.weatherapi.common.RealtimeWeather;
import com.himanshu.weatherapi.location.LocationDataNotFoundException;
import com.himanshu.weatherapi.location.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RealtimeWeatherService {

    private final RealtimeWeatherRepository realtimeWeatherRepository;
    private final LocationRepository locationRepository;

    public RealtimeWeatherService(RealtimeWeatherRepository realtimeWeatherRepository, LocationRepository locationRepository) {
        this.realtimeWeatherRepository = realtimeWeatherRepository;
        this.locationRepository = locationRepository;
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

    public RealtimeWeather updateRealtimeWeather(String locationCode, RealtimeWeather realtimeWeather) throws LocationDataNotFoundException {
        Location location = locationRepository.findFirstByCode(locationCode);
        if (location == null) {
            throw new LocationDataNotFoundException("No location data found for " + locationCode);
        }
        realtimeWeather.setLocation(location);
        realtimeWeather.setLastUpdated(new Date());
        if (location.getRealtimeWeather() == null) {
            location.setRealtimeWeather(realtimeWeather);
            Location updateLocation = locationRepository.save(location);
            return updateLocation.getRealtimeWeather();
        }
        return realtimeWeatherRepository.save(realtimeWeather);
    }
}

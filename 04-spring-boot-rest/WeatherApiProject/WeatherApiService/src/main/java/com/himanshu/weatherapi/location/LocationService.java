package com.himanshu.weatherapi.location;

import com.himanshu.weatherapi.common.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    public List<Location> getAllUntarnishedLocations() {
        return locationRepository.findUntarnishedLocations();
    }

    public Location getLocationByCode(String code) {
        return locationRepository.findFirstByCode(code);
    }

    public Location updateLocation(Location location) {
        Location updatedLocation = locationRepository.findFirstByCode(location.getCode());
        if (updatedLocation == null) {
            throw new LocationDataNotFoundException("No location found with the location code: "+location.getCode());
        }
        updatedLocation.setCountryCode(location.getCountryCode());
        updatedLocation.setCountryName(location.getCountryName());
        updatedLocation.setRegionName(location.getRegionName());
        updatedLocation.setCountryCode(location.getCountryCode());
        updatedLocation.setEnabled(location.isEnabled());
        return locationRepository.save(updatedLocation);
    }
}

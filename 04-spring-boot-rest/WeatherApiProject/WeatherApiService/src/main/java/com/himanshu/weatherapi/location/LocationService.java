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
}

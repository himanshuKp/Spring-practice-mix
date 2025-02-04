package com.himanshu.weatherapi.location;

import com.himanshu.weatherapi.common.Location;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/locations")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public ResponseEntity<Location> save(@RequestBody @Valid Location location) {
        Location savedLocation = locationService.addLocation(location);
        URI locationURI =
                URI.create("/v1/locations/"+savedLocation.getCode());
        return ResponseEntity.created(locationURI).body(savedLocation);
    }

    @GetMapping
    public ResponseEntity<?> findUntarnishedLocations() {
        List<Location> untarnishedLocations = locationService.getAllUntarnishedLocations();
        if(untarnishedLocations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(untarnishedLocations);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Location> findByCode(@PathVariable("code") String code) {
        Location location = locationService.getLocationByCode(code);
        if(location == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(location);
    }

    @PutMapping
    public ResponseEntity<Location> updateLocation(@RequestBody @Valid Location location) {
        try {
            Location updatedLocation = locationService.updateLocation(location);
            return ResponseEntity.ok(updatedLocation);
        } catch (LocationDataNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

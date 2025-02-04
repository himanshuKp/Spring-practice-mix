package com.himanshu.weatherapi.location;

import com.himanshu.weatherapi.common.Location;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping(value = "/v1/locations")
    public ResponseEntity<Location> save(@RequestBody @Valid Location location) {
        Location savedLocation = locationService.addLocation(location);
        URI locationURI =
                URI.create("/v1/locations/"+savedLocation.getCode());
        return ResponseEntity.created(locationURI).body(savedLocation);
    }
}

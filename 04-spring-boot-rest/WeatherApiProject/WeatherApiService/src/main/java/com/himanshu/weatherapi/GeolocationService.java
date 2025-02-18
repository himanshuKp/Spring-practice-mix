package com.himanshu.weatherapi;

import com.himanshu.weatherapi.common.Location;
import com.ip2location.IP2Location;
import com.ip2location.IPResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GeolocationService {

    private final Logger logger = LoggerFactory.getLogger(GeolocationService.class);

    private String dbPath = "ip2locdb/IP2LOCATION-LITE-DB3.BIN";
    private IP2Location ip2Location = new IP2Location();

    public GeolocationService() {
        try {
            ip2Location.Open(dbPath);
        } catch (IOException e) {
            throw new GeolocationException(e.getMessage(), e);
        }
    }

    public Location getLocation(String ipAddress) throws GeolocationException {
        try {
            IPResult ipResult = ip2Location.IPQuery(ipAddress);

            if (!"OK".equals(ipResult.getStatus())) {
                throw new GeolocationException("Geolocation failed with status: "+ipResult.getStatus());
            }
            logger.info("Geolocation IP address: {}",ipAddress);
            return new Location(ipResult.getCity(), ipResult.getRegion(), ipResult.getCountryLong(), ipResult.getCountryShort());
        } catch (IOException exception){
            throw new GeolocationException(exception.getMessage(), exception);
        }
    }
}

package com.himanshu.weatherapi.location;

import com.himanshu.weatherapi.common.HourlyWeather;
import com.himanshu.weatherapi.common.Location;
import com.himanshu.weatherapi.common.RealtimeWeather;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class LocationRepositoryTest {
    @Autowired
    private LocationRepository locationRepository;

    @Test
    public void testAddLocation() {
        Location location = new Location();
        location.setCode("NYC_USA");
        location.setCityName("New York");
        location.setCountryCode("US");
        location.setCountryName("United States");
        location.setRegionName("New York");
        location.setEnabled(true);

        Location savedLocation = locationRepository.save(location);
        assert savedLocation.getCode().equalsIgnoreCase("NYC_USA");
    }

    @Test
    public void testUntarnishedLocation() {
        List<Location> locations = locationRepository.findUntarnishedLocations();

        assert !locations.isEmpty();
        locations.forEach(System.out::println);
    }

    @Test
    public void testDeleteLocation() {
        locationRepository.trashByCode("NYC_USA");
        Location location = locationRepository.findFirstByCode("NYC_USA");
        assert location == null;
    }

    @Test
    public void testAddRealtimeWeatherData() {
        String code = "DELHI_IND";

        Location location = locationRepository.findFirstByCode(code);

        RealtimeWeather realtimeWeather = location.getRealtimeWeather();

        if (realtimeWeather == null) {
            realtimeWeather = new RealtimeWeather();
            realtimeWeather.setLocation(location);
            location.setRealtimeWeather(realtimeWeather);
        }
        realtimeWeather.setHumidity(40);
        realtimeWeather.setStatus("Sunny");
        realtimeWeather.setTemperature(40);
        realtimeWeather.setWindSpeed(20);
        realtimeWeather.setPrecipitation(50);
        realtimeWeather.setLastUpdated(new Date());
        Location updatedLocation = locationRepository.save(location);

        assert updatedLocation.getRealtimeWeather().getLocationCode().equalsIgnoreCase(code);
    }
    
    @Test
    public void testAddHourlyWeatherData() {
        Optional<Location> location = locationRepository.findById("DELHI_IND");
        assert location.isPresent();

        List<HourlyWeather> listHourlyWeather = location.get().getHourlyWeatherList();

        HourlyWeather forecast1 = new HourlyWeather().hourOfDay(10)
                                                .location(location.get())
                                                .precipitation(10)
                                                .temperature(44)
                                                .status("Sunny");
                                                
        HourlyWeather forecast2 = new HourlyWeather().hourOfDay(11)
                                                .location(location.get())
                                                .precipitation(22)
                                                .temperature(45)
                                                .status("Sunny");

        listHourlyWeather.add(forecast1);
        listHourlyWeather.add(forecast2);

        Location updatedLocation = locationRepository.save(location.get());

        assert !updatedLocation.getHourlyWeatherList().isEmpty();
    }
}

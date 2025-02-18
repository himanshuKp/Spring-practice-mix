package com.himanshu.weatherapi.realtime;

import com.himanshu.weatherapi.common.RealtimeWeather;
import com.himanshu.weatherapi.location.LocationDataNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RealtimeWeatherRepositoryTest {
    @Autowired
    private RealtimeWeatherRepository realtimeWeatherRepository;

    @Test
    public void testUpdateRealtimeWeather() {
        String location = "DELHI_IND";
        RealtimeWeather realtimeWeather = realtimeWeatherRepository.findById(location).isPresent() ?
                realtimeWeatherRepository.findById(location).get() :
                null;

        assert realtimeWeather != null;
        realtimeWeather.setHumidity(20);

        realtimeWeather.setStatus("Sunny");
        realtimeWeather.setTemperature(80);
        realtimeWeather.setWindSpeed(20);
        realtimeWeather.setPrecipitation(50);
        realtimeWeather.setLastUpdated(new Date());

        RealtimeWeather updatedRealtimeWeather = realtimeWeatherRepository.save(realtimeWeather);
        assert updatedRealtimeWeather.getTemperature() == 80 : "Temperature should be equal to 80";
    }

    @Test
    public void testFindRealtimeWeatherByCountryCodeAndCityFailed() {
        String countryCode = "US";
        String city = "NYC";

        RealtimeWeather realtimeWeather = realtimeWeatherRepository.findByCityNameAndCountryCode(city, countryCode);
        assert realtimeWeather == null;
    }

    @Test
    public void testFindRealtimeWeatherByCountryCodeAndCity() {
        String countryCode = "IN";
        String cityName = "Delhi";
        RealtimeWeather realtimeWeather = realtimeWeatherRepository.findByCityNameAndCountryCode(cityName, countryCode);
        assert realtimeWeather != null;
        assert realtimeWeather.getLocation().getCityName().equals(cityName);
    }

    @Test
    public void testFindByLocationNotFound() {
        String location = "XYZ_IND";
        RealtimeWeather realtimeWeather = realtimeWeatherRepository.findByLocationCode(location);
        assert realtimeWeather == null;
    }

    @Test
    public void testFindByTrashedLocationNotFound() {
        String location = "NYC_USA";
        RealtimeWeather realtimeWeather = realtimeWeatherRepository.findByLocationCode(location);
        assert realtimeWeather == null;
    }

    @Test
    public void testFindByLocationFound() {
        String location = "DELHI_IND";
        RealtimeWeather realtimeWeather = realtimeWeatherRepository.findByLocationCode(location);
        assert realtimeWeather != null;
    }
}

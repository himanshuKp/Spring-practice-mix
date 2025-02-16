package com.himanshu.weatherapi.realtime;

import com.himanshu.weatherapi.common.RealtimeWeather;
import org.junit.jupiter.api.Test;
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
}

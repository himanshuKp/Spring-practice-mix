package com.himanshu.weatherapi.location;

import com.himanshu.weatherapi.common.Location;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

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
}

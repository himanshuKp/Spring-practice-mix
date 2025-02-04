package com.himanshu.weatherapi.location;

import com.himanshu.weatherapi.common.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, String> {
    @Query("SELECT l from Location l where l.trashed = false")
    public List<Location> findUntarnishedLocations();

    @Query("SELECT l from Location l where l.code=?1 and l.trashed = false")
    public Location findFirstByCode(String code);
}

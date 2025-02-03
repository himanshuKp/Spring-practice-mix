package com.himanshu.weatherapi.location;

import com.himanshu.weatherapi.common.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, String> {}

package com.anuschka.locations.repository;

import com.anuschka.locations.entity.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {

}

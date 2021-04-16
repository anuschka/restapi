package com.anuschka.locations.service;

import com.anuschka.locations.entity.Location;
import com.anuschka.locations.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    LocationRepository locationRepository;

    public List<Location> retrieveLocations(){
        return (List<Location>)locationRepository.findAll();
    }
}

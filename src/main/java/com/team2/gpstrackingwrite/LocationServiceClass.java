package com.team2.gpstrackingwrite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class LocationServiceClass implements LocationService {
    @Autowired
    private LocationRepo locationRepository;

    @Override
    public List<LocationDomain> findAll() {
        var locations = (List<LocationDomain>) locationRepository.findAll();
        return locations;
    }

    @Override
    public LocationDomain create(LocationDomain location) {
        return locationRepository.save(location);
    }


}

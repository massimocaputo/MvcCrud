package com.acn.nemo.service.impl;

import com.acn.nemo.dto.LocationDto;
import com.acn.nemo.exception.LocationNotFoundException;
import com.acn.nemo.mapper.LocationMapper;
import com.acn.nemo.model.Location;
import com.acn.nemo.repository.LocationRepository;
import com.acn.nemo.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Location service.
 */
@Service
@Slf4j
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LocationMapper locationMapper;

    /**
     * @param location
     * @return
     */
    @Override
    public LocationDto saveInvice(LocationDto location) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<LocationDto> getLocations() {
        log.info("Init getLocations");
         List<Location> locationList = locationRepository.findAll();
         List<LocationDto> locationDtoList = new ArrayList<>();
         for (Location location : locationList) {
             locationDtoList.add(locationMapper.entityToDto(location));
         }
        log.info("End getLocations");
        return locationDtoList;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public LocationDto getLocationById(Short id) {
        log.info("Init getLocationById");
        Optional<Location> location = locationRepository.findById(id);
        if(location.isPresent()) {
            log.info("End getLocationById");
            return locationMapper.entityToDto(location.get());
        }else {
            log.error("Location not found");
            throw new LocationNotFoundException();
        }
    }

    /**
     * @param id
     */
    @Override
    public void deleteLocationById(Short id) {

    }

    @Transactional(readOnly = false)
    @Override
    public LocationDto updateLocation(LocationDto locationDto) {
        log.info("Init updateLocation");

        if(null != locationDto){
            Location newLocation = locationRepository.save(locationMapper.dtoToEntity(locationDto));
            log.info("End updateLocation");
            return locationMapper.entityToDto(newLocation);
        }else {
            return null;
        }
    }
}

package com.acn.nemo.service;

import com.acn.nemo.dto.LocationDto;

import java.util.List;

public interface LocationService {

    public LocationDto saveInvice(LocationDto location);
    public List<LocationDto> getLocations();
    public LocationDto getLocationById(Short id);
    public void deleteLocationById(Short id);
    public LocationDto updateLocation(LocationDto location);
}

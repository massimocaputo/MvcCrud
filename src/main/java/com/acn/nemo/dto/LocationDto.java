package com.acn.nemo.dto;

import com.acn.nemo.model.Location;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Location}
 */
@Value
public class LocationDto implements Serializable {
    Short id;
    String streetAddress;
    String postalCode;
    String city;
    String stateProvince;
    CountryDto country;
}
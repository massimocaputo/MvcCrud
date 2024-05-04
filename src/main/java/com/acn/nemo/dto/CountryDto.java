package com.acn.nemo.dto;

import com.acn.nemo.model.Region;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.acn.nemo.model.Country}
 */
@Value
public class CountryDto implements Serializable {
    String countryId;
    String countryName;
    Region region;
    //Set<LocationDto> locations;
}
package com.acn.nemo.mapper;

import com.acn.nemo.dto.CountryDto;
import com.acn.nemo.model.Country;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {RegionMapper.class, LocationMapper.class})
public interface CountryMapper {
    Country toEntity(CountryDto countryDto);

    CountryDto toDto(Country country);

//    @AfterMapping
//    default void linkLocations(@MappingTarget Country country) {
//        country.getLocations().forEach(location -> location.setCountry(country));
//    }


//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Country partialUpdate(CountryDto countryDto, @MappingTarget Country country);
}
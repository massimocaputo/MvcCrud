package com.acn.nemo.mapper;

import com.acn.nemo.dto.LocationDto;
import com.acn.nemo.model.Location;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {CountryMapper.class})
public interface LocationMapper {
    Location dtoToEntity(LocationDto locationDto);

    LocationDto entityToDto(Location location);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Location partialUpdate(LocationDto locationDto, @MappingTarget Location location);
}
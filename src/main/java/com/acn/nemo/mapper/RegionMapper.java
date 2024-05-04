package com.acn.nemo.mapper;

import com.acn.nemo.model.Region;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegionMapper {
    Region toEntity(Region region);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Region partialUpdate(Region region, @MappingTarget Region region);
}
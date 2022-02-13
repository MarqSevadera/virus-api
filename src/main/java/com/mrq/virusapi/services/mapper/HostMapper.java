package com.mrq.virusapi.services.mapper;

import com.mrq.virusapi.repositories.models.HostEntity;
import com.mrq.virusapi.web.model.Host;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {VirusMapper.class})
public interface HostMapper {
    HostMapper INSTANCE = Mappers.getMapper(HostMapper.class);

    HostEntity map(Host host);

    Host mapEntity(HostEntity hostEntity);

}

package com.mrq.virusapi.services.mapper;

import com.mrq.virusapi.repositories.models.HostEntity;
import com.mrq.virusapi.repositories.models.VirusEntity;
import com.mrq.virusapi.web.model.Host;
import com.mrq.virusapi.web.model.Virus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VirusMapper {
    VirusMapper INSTANCE = Mappers.getMapper(VirusMapper.class);

    VirusEntity map(Virus virus);

    @Mapping(ignore = true, target = "viralFamily.viruses")
    Virus mapEntity(VirusEntity virusEntity);

    default List<Host> mapHostEntities(List<HostEntity> hostEntities) {
        if (hostEntities == null || hostEntities.isEmpty()) return Collections.emptyList();
        return hostEntities.stream().map(v -> {
            v.setKnownViruses(null);
            return HostMapper.INSTANCE.mapEntity(v);
        }).collect(Collectors.toList());
    }


}

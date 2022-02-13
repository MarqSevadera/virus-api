package com.mrq.virusapi.services.mapper;

import com.mrq.virusapi.repositories.models.ViralFamilyEntity;
import com.mrq.virusapi.web.model.ViralFamily;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,uses = {VirusMapper.class})
public interface ViralFamilyMapper {
    ViralFamilyMapper INSTANCE = Mappers.getMapper(ViralFamilyMapper.class);

    ViralFamilyEntity map(ViralFamily viralFamily);

    ViralFamily mapEntity(ViralFamilyEntity viralFamilyEntity);


}

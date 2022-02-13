package com.mrq.virusapi.services;

import com.mrq.virusapi.repositories.dao.ViralFamilyJpaRepository;
import com.mrq.virusapi.repositories.models.ViralFamilyEntity;
import com.mrq.virusapi.services.mapper.ViralFamilyMapper;
import com.mrq.virusapi.web.model.ViralFamily;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ViralFamilyService {
    private final ViralFamilyJpaRepository viralFamilyJpaRepository;

    public Page<ViralFamily> list(int pageNum, int pageSize) {
        Pageable pageRequest = PageRequest.of(pageNum, pageSize, Sort.by("name").ascending());
        Page<ViralFamilyEntity> viralFamilyEntityPage = viralFamilyJpaRepository.findAll(pageRequest);
        List<ViralFamily> viralFamilyList = viralFamilyEntityPage.getContent().stream().map(ViralFamilyMapper.INSTANCE::mapEntity).collect(Collectors.toList());
        return new PageImpl<>(viralFamilyList, pageRequest, viralFamilyEntityPage.getTotalElements());
    }

    public ViralFamily findById(BigInteger id) {
        return viralFamilyJpaRepository.findById(id).map(ViralFamilyMapper.INSTANCE::mapEntity)
                .orElseThrow(() -> new EntityNotFoundException("Can't find viral family with id: " + id));
    }

    public ViralFamily save(ViralFamily viralFamily) {
        ViralFamilyEntity viralFamilyEntity = viralFamilyJpaRepository.save(ViralFamilyMapper.INSTANCE.map(viralFamily));
        return ViralFamilyMapper.INSTANCE.mapEntity(viralFamilyEntity);
    }

    @Transactional
    public ViralFamily deleteById(BigInteger id) {
        ViralFamily viralFamily = findById(id);
        viralFamilyJpaRepository.deleteById(id);
        return viralFamily;
    }
}

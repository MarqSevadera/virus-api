package com.mrq.virusapi.services;

import com.mrq.virusapi.repositories.dao.VirusJpaRepository;
import com.mrq.virusapi.repositories.models.VirusEntity;
import com.mrq.virusapi.services.mapper.VirusMapper;
import com.mrq.virusapi.web.model.Virus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VirusService {

    private final VirusJpaRepository virusJpaRepository;

    public Page<Virus> list(String familyName, int pageNum, int pageSize) {
        Pageable pageRequest = PageRequest.of(pageNum, pageSize, Sort.by("name").ascending());
        Page<VirusEntity> virusEntityPage = StringUtils.isEmpty(familyName) ? virusJpaRepository.findAll(pageRequest)
                : virusJpaRepository.findByViralFamilyName(familyName, pageRequest);

        List<Virus> virusList = virusEntityPage.getContent().stream().map(VirusMapper.INSTANCE::mapEntity).collect(Collectors.toList());
        return new PageImpl<>(virusList, pageRequest, virusEntityPage.getTotalElements());
    }

    public Virus findById(BigInteger id) {
        return virusJpaRepository.findById(id).map(VirusMapper.INSTANCE::mapEntity)
                .orElseThrow(() -> new EntityNotFoundException("Can't find virus with id: " + id));
    }

    public Virus save(Virus virus) {
        VirusEntity virusEntity = virusJpaRepository.save(VirusMapper.INSTANCE.map(virus));
        return VirusMapper.INSTANCE.mapEntity(virusEntity);
    }

    @Transactional
    public Virus deleteById(BigInteger id) {
        Virus virus = findById(id);
        virusJpaRepository.deleteById(id);
        return virus;
    }
}

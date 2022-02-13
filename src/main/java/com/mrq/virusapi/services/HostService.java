package com.mrq.virusapi.services;

import com.mrq.virusapi.repositories.dao.HostJpaRepository;
import com.mrq.virusapi.repositories.models.HostEntity;
import com.mrq.virusapi.services.mapper.HostMapper;
import com.mrq.virusapi.web.model.Host;
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
public class HostService {

    private final HostJpaRepository hostJpaRepository;

    public Page<Host> list(int pageNum, int pageSize) {
        Pageable pageRequest = PageRequest.of(pageNum, pageSize, Sort.by("name").ascending());
        Page<HostEntity> hostEntityPage = hostJpaRepository.findAll(pageRequest);
        List<Host> hostList = hostEntityPage.getContent().stream().map(HostMapper.INSTANCE::mapEntity).collect(Collectors.toList());
        return new PageImpl<>(hostList, pageRequest, hostEntityPage.getTotalElements());
    }

    public Host findById(BigInteger id) {
        return hostJpaRepository.findById(id).map(HostMapper.INSTANCE::mapEntity)
                .orElseThrow(() -> new EntityNotFoundException("Can't find host with id: " + id));
    }

    public Host save(Host host) {
        HostEntity hostEntity = hostJpaRepository.save(HostMapper.INSTANCE.map(host));
        return HostMapper.INSTANCE.mapEntity(hostEntity);
    }

    @Transactional
    public Host deleteById(BigInteger id) {
        Host host = findById(id);
        hostJpaRepository.deleteById(id);
        return host;
    }

}

package com.mrq.virusapi.repositories.dao;

import com.mrq.virusapi.repositories.models.VirusEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface VirusJpaRepository extends JpaRepository<VirusEntity, BigInteger> {
    Page<VirusEntity> findByViralFamilyName(String name, Pageable pageable);
}

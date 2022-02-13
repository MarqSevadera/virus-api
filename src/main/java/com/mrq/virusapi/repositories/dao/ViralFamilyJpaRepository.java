package com.mrq.virusapi.repositories.dao;

import com.mrq.virusapi.repositories.models.ViralFamilyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ViralFamilyJpaRepository extends JpaRepository<ViralFamilyEntity, BigInteger> {
}

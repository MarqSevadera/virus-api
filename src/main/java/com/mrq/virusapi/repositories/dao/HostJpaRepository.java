package com.mrq.virusapi.repositories.dao;

import com.mrq.virusapi.repositories.models.HostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface HostJpaRepository extends JpaRepository<HostEntity, BigInteger> {
}

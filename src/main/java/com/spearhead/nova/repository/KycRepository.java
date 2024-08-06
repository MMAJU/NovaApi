package com.spearhead.nova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spearhead.nova.model.Kyc;

@Repository
public interface KycRepository extends JpaRepository<Kyc, Long> {

}

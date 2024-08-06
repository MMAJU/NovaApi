package com.spearhead.nova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spearhead.nova.model.Fund;

@Repository
public interface FundRepository extends JpaRepository<Fund, Long> {

}

package com.spearhead.nova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spearhead.nova.model.FundRedemption;

@Repository
public interface fundRedemptionRepository extends JpaRepository<FundRedemption, Long>  {
	

}

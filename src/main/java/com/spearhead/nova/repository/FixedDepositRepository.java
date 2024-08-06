package com.spearhead.nova.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spearhead.nova.model.FixedDeposit;


@Repository
public interface FixedDepositRepository extends JpaRepository <FixedDeposit, Long> {
	
	List<FixedDeposit> findAllByPlacementId(String placementId);
	Optional<FixedDeposit> findByCustomerId(String customerId);

}

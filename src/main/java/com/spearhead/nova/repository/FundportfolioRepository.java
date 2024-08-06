package com.spearhead.nova.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spearhead.nova.model.FundPortfolio;

@Repository
public interface FundportfolioRepository extends JpaRepository <FundPortfolio, Long> {
	
	Optional<FundPortfolio> findByAccountId(String accountId);
	Optional<FundPortfolio> findByCustomerId(String customerId);

}

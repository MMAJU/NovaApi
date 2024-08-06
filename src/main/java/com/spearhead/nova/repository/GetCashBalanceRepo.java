package com.spearhead.nova.repository;

import java.util.Optional;

import com.spearhead.nova.model.GetCashBalance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GetCashBalanceRepo extends JpaRepository<GetCashBalance, Long> {
    Optional <GetCashBalance> findByCustomerId(String customerId);
}

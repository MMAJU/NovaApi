package com.spearhead.nova.repository;

import com.spearhead.nova.model.CashDeposit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CashDepositRepo extends JpaRepository <CashDeposit, Long> {
    
}

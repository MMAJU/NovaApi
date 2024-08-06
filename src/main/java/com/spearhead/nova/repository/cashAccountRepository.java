package com.spearhead.nova.repository;

import com.spearhead.nova.model.CashAccount;

import org.springframework.data.jpa.repository.JpaRepository;

public interface cashAccountRepository extends JpaRepository <CashAccount, Long>{
    
}

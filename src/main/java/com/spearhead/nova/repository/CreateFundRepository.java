package com.spearhead.nova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spearhead.nova.model.CreateFundAccount;

@Repository
public interface CreateFundRepository extends JpaRepository <CreateFundAccount, Long> {
	
	
}

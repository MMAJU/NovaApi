package com.spearhead.nova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spearhead.nova.model.FundSubscription;

@Repository
public interface FundSubscriptionRepository extends JpaRepository <FundSubscription, Long> {

}

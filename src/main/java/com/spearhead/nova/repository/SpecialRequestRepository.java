package com.spearhead.nova.repository;

import com.spearhead.nova.model.SpecialRequest;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialRequestRepository extends JpaRepository<SpecialRequest, Long> {
    Optional <SpecialRequest> findByCustomerId(String customerId);
}

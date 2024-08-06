package com.spearhead.nova.repository;

import com.spearhead.nova.model.DoPlacement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface placementRepo extends JpaRepository <DoPlacement, Long> {
    
}

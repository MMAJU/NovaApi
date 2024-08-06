package com.spearhead.nova.repository;

import com.spearhead.nova.model.About;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AboutRepository extends JpaRepository<About, Long> {

    
}

package com.spearhead.nova.repository;

import com.spearhead.nova.model.Terms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TermRepository extends JpaRepository<Terms, Long>{
    
}

package com.spearhead.nova.repository;

import com.spearhead.nova.model.Stocks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StocksRepository extends JpaRepository <Stocks, Long> {
    
}

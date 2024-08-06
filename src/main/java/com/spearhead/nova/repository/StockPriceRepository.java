package com.spearhead.nova.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spearhead.nova.model.StockPrice;


@Repository
public interface StockPriceRepository extends JpaRepository <StockPrice, Long>{

	
	Optional<StockPrice> findBySymbolCode(String symbolCode);
	
}

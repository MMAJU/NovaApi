package com.spearhead.nova.repository;

import java.util.List;
import java.util.Optional;

import com.spearhead.nova.model.CashAccountGet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CashAccountGetRepo extends JpaRepository<CashAccountGet, Long> {

   

    @Query(value = "Select * from cash_account_get  where created_at BETWEEN :startDate AND :endDate AND customer_id = :customerId ", nativeQuery = true )
	public List<CashAccountGet> getAllBetweenDates(@Param("startDate")String startDate,@Param("endDate") String endDate, @Param("customerId") String  customerId);
    
    Optional <CashAccountGet> findByCustomerId(String customerId);
}

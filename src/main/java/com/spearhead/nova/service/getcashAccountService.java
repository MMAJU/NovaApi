package com.spearhead.nova.service;

import java.util.List;

import com.spearhead.nova.model.CashAccountGet;
import com.spearhead.nova.model.StandardResponse;

import org.springframework.http.ResponseEntity;

public interface getcashAccountService {

    ResponseEntity<StandardResponse> getcashaccountById(String customerId);

    List<CashAccountGet> getAllBetweenDates(String startDate, String endDate, String customerId);
    
}

package com.spearhead.nova.service;

import com.spearhead.nova.model.StandardResponse;

import org.springframework.http.ResponseEntity;

public interface GetCashBalanceService {


    ResponseEntity<StandardResponse> getcashBalanceById(String customerId);
    
}

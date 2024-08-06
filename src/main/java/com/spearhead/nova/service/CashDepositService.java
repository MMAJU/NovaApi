package com.spearhead.nova.service;

import com.spearhead.nova.model.CashDeposit;
import com.spearhead.nova.model.StandardResponse;

import org.springframework.http.ResponseEntity;

public interface CashDepositService {

    ResponseEntity<StandardResponse> docashdeposit(CashDeposit cashDeposit);
    
}

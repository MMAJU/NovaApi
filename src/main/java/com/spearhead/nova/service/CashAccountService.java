package com.spearhead.nova.service;

import com.spearhead.nova.model.CashAccount;
import com.spearhead.nova.model.StandardResponse;

import org.springframework.http.ResponseEntity;

public interface CashAccountService {

    ResponseEntity<StandardResponse> docashaccount(CashAccount cashAccount);
    
}

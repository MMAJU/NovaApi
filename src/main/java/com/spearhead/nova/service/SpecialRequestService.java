package com.spearhead.nova.service;

import com.spearhead.nova.model.SpecialRequest;
import com.spearhead.nova.model.StandardResponse;

import org.springframework.http.ResponseEntity;

public interface SpecialRequestService {

    public SpecialRequest saveSpecialRequest(SpecialRequest specialRequest);

    ResponseEntity<StandardResponse> getSpecialRequest(String customerId);
    
}

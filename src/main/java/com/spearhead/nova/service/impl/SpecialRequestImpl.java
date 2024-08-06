package com.spearhead.nova.service.impl;

import com.spearhead.nova.model.SpecialRequest;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.repository.AboutRepository;
import com.spearhead.nova.repository.SpecialRequestRepository;
import com.spearhead.nova.service.SpecialRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SpecialRequestImpl implements SpecialRequestService{

    @Autowired
    private SpecialRequestRepository specialRequestRepository;

	@Override
	public SpecialRequest saveSpecialRequest(SpecialRequest specialRequest) {
		// TODO Auto-generated method stub
		return specialRequestRepository.save(specialRequest);
	}

	@Override
	public ResponseEntity<StandardResponse> getSpecialRequest(String customerId) {
		// TODO Auto-generated method stub
        try {

            Object data = specialRequestRepository.findByCustomerId(customerId).get();
     
             StandardResponse sr = new StandardResponse();
             sr.setData(data);
             sr.setMessage("Get Customers Special Request  By Customer Id");
             sr.setStatus(true);
             sr.setStatuscode("200");
             
     
               return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
           } catch (Exception e) {
               //TODO: handle exception
               StandardResponse sr = new StandardResponse();
               sr.setStatus(false);
               return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
          }
	}

  
    
}

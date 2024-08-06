package com.spearhead.nova.service.impl;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.repository.GetCashBalanceRepo;
import com.spearhead.nova.service.GetCashBalanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetCashBalanceImpl  implements GetCashBalanceService{

    @Autowired
    private GetCashBalanceRepo getCashBalanceRepo;

   

    @Override
    public ResponseEntity<StandardResponse> getcashBalanceById(String customerId) {
        // TODO Auto-generated method stub
        try {

            Object data = getCashBalanceRepo.findByCustomerId(customerId).get();
     
             StandardResponse sr = new StandardResponse();
             sr.setData(data);
             sr.setMessage("Get Customers Account By Customer Id");
             sr.setStatus(true);
             sr.setStatuscode("200");
             
     
               return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
           } catch (Exception e) {
               //TODO: handle exception
               StandardResponse sr = new StandardResponse();
               sr.setStatus(false);
               return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
          }
    }
    
}

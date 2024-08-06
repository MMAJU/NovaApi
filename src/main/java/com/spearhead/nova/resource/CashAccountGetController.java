package com.spearhead.nova.resource;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.spearhead.nova.model.CashAccountGet;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.service.getcashAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
    "Customer Account" }, description = "Rest APIs that Returns Information Corncering the Customer Account")
    @RestController
    @RequestMapping("/api/customeraccount")
public class CashAccountGetController {
    @Autowired
    private getcashAccountService getAcctSercive;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getcashacctById/{customerid}")
    public ResponseEntity<StandardResponse> getcashacctById(@PathVariable("customerid") String customerId) {
        return getAcctSercive.getcashaccountById(customerId);
        
    }



    @GetMapping("/getcashAccountByCustomerId/{startDate}/{endDate}/{customerId}")
    public List<CashAccountGet> getAllBetweenDates(@PathVariable("startDate") String  startDate,
            @PathVariable("endDate") String endDate, @PathVariable("customerId") String customerId){
               return getAcctSercive.getAllBetweenDates(startDate, endDate, customerId) ;
       
        
    }

    
}

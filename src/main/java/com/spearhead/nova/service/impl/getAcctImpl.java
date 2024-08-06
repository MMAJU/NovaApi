package com.spearhead.nova.service.impl;

import java.util.List;

import com.spearhead.nova.model.CashAccountGet;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.repository.CashAccountGetRepo;
import com.spearhead.nova.service.getcashAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class getAcctImpl implements getcashAccountService {

    @Autowired
    private CashAccountGetRepo cashAccountgetRepo;

    @Override
    public ResponseEntity<StandardResponse> getcashaccountById(String customerId) {
        // TODO Auto-generated method stub
      

			try {

                Object data = cashAccountgetRepo.findByCustomerId(customerId).get();
		 
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

    @Override
    public List<CashAccountGet> getAllBetweenDates(String startDate, String endDate, String customerId) {
        // TODO Auto-generated method stub
        return cashAccountgetRepo.getAllBetweenDates(startDate, endDate, customerId);
    }
    
}

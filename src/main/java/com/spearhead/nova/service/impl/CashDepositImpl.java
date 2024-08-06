package com.spearhead.nova.service.impl;

import com.spearhead.nova.model.CashDeposit;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.repository.CashDepositRepo;
import com.spearhead.nova.service.CashDepositService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CashDepositImpl implements CashDepositService{

    @Autowired
    private CashDepositRepo cashDepositRepo;
    @Override
    public ResponseEntity<StandardResponse> docashdeposit(CashDeposit cashDeposit) {
        // TODO Auto-generated method stub
        Object data =  cashDepositRepo.save(cashDeposit);
        StandardResponse sr = new StandardResponse();
        sr.setStatus(true);
        sr.setMessage("Cash Account Created");
        sr.setData(data);
        return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
    }
    
}

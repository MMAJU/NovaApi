package com.spearhead.nova.service.impl;

import com.spearhead.nova.model.CashAccount;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.repository.cashAccountRepository;
import com.spearhead.nova.service.CashAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CashAccountImpl implements CashAccountService{


    @Autowired
    private cashAccountRepository cashAccountRepo;
    @Override
    public ResponseEntity<StandardResponse> docashaccount(CashAccount cashAccount) {
        // TODO Auto-generated method stub

        Object data =  cashAccountRepo.save(cashAccount);

        StandardResponse sr = new StandardResponse();
        sr.setStatus(true);
        sr.setMessage("Cash Account Created");
        sr.setData(data);
        return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
    }
    
}

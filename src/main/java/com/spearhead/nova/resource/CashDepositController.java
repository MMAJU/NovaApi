package com.spearhead.nova.resource;

import com.spearhead.nova.service.CashDepositService;
import com.spearhead.nova.model.CashDeposit;
import com.spearhead.nova.model.StandardResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
        "Customer Account" }, description = "Rest APIs that Returns Information Corncering the Customer Account")
@RestController
@RequestMapping("/api/customeraccount")

public class CashDepositController {

    @Autowired
    private CashDepositService cashDepositService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/docashdeposit")
    public ResponseEntity<StandardResponse> docashdeposit(@RequestBody CashDeposit cashDeposit) {
        return cashDepositService.docashdeposit(cashDeposit);

    }

}

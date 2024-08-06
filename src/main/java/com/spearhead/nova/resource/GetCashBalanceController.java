package com.spearhead.nova.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.pojoClasses.GeneralSymplusResponse;
import com.spearhead.nova.service.GetCashBalanceService;
import com.spearhead.nova.util.ValidateEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
    "Customer Account" }, description = "Rest APIs that Returns Information Corncering the Customer Account")
    @RestController
    @RequestMapping("/api/customeraccount")
public class GetCashBalanceController {

    @Autowired
    private GetCashBalanceService getCashBalance;

    @Value("${spearhead.symplusservice}")
    private  String baseDevURL;

    RestTemplate restTemplate;


    private  Map<String, Object> extractDataMethod(ResponseEntity<GeneralSymplusResponse> resultr) {
		Map<String, Object> data = new HashMap<>();
//loop through Get Fund Array and display item you want
for (Map<String, ArrayList<Map<String, Object> > > funds : resultr.getBody().getResult()) {
 for ( Map<String, Object> fund  : funds.get("GetCashAccounts")){
	data.put("Customer Number ", fund.get("CUSTOMER_NO"));
	data.put("Account Number", fund.get("ACCOUNT_NO"));
	data.put("Account Name", fund.get("ACCOUNT_NAME"));
	data.put("Available Balance", fund.get("AVAILABLE_BALANCE"));
	data.put("Current Balance", fund.get("CURRENT_BALANCE"));
	data.put("Accrued Credit Interest", fund.get("ACCRUED_CREDIT_INTEREST"));

    data.put("Accrued Debit Interest", fund.get("ACCRUED_DEBIT_INTEREST"));
	data.put("PDate Opened", fund.get("DATE_OPENED"));
	data.put("Last Debit Date", fund.get("LAST_DEBIT_DATE"));
    data.put("Last Credit Date", fund.get("LAST_CREDIT_DATE"));
 }
}
		return data;
	}


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getcashBalance/{customerid}")
    public ResponseEntity<StandardResponse> getcashBalanceById(@PathVariable("customerid") String customerId) 
    throws URISyntaxException {
        //return getCashBalance.getcashBalanceById(customerId);
        String path = baseDevURL + "/GetCashAccounts/" + customerId;
    
        StandardResponse sr = new StandardResponse();
		HttpEntity<String> entity = ValidateEntity.getentity("");

        try {
			URI uri = new URI(path);
			ResponseEntity<GeneralSymplusResponse> resultr = restTemplate.exchange(uri, HttpMethod.GET, entity, GeneralSymplusResponse.class);
			
			if(!resultr.getBody().getStatus().equalsIgnoreCase("success")){
				sr.setStatus(false);
				return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
			}

			Map<String, Object> data = extractDataMethod(resultr);
			//Object data = fixedDepositService.getPlacementByCustomerId(customerId);
	 
			 
			 sr.setData(data);
			 sr.setMessage("Get Cash Account");
			 sr.setStatus(true);
			 sr.setStatuscode("200");
			 
	 
			   return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		   } catch (Exception e) {
			   //TODO: handle exception
			 
			   sr.setStatus(false);
			   return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		  }
      
        
    }
}

package com.spearhead.nova.service;

import org.codehaus.jettison.json.JSONException;
import org.springframework.http.ResponseEntity;

import com.spearhead.nova.model.FundPortfolio;
import com.spearhead.nova.model.StandardResponse;

public interface FundPortfolioService {


	
	ResponseEntity<StandardResponse> saveFunPortfolio(FundPortfolio fundPortfolio);

	FundPortfolio getFundPortfolio(String customerid);



	

}

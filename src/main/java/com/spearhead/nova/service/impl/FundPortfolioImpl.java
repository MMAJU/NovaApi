package com.spearhead.nova.service.impl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spearhead.nova.model.FundPortfolio;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.repository.FundportfolioRepository;
import com.spearhead.nova.service.FundPortfolioService;
import com.spearhead.nova.util.MethodUtils;



@Service
public class FundPortfolioImpl implements FundPortfolioService {

	@Autowired
	private FundportfolioRepository fundRepo;
	
	@Override
	public ResponseEntity<StandardResponse> saveFunPortfolio(FundPortfolio fundPortfolio) {
		// TODO Auto-generated method stub
		
		StandardResponse sr = new StandardResponse();
		sr.setStatus(true);
		sr.setStatuscode("200");
		sr.setMessage("Fund Portfolio Save");
		 fundRepo.save(fundPortfolio);
		 return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		 
	}

	@Override
	public FundPortfolio getFundPortfolio(String customerId) {
		// TODO Auto-generated method stub
		return fundRepo.findByCustomerId(customerId).get();
	}


	


}

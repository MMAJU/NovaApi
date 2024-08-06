package com.spearhead.nova.service.impl;


import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.spearhead.nova.model.CreateFundAccount;
import com.spearhead.nova.model.Fund;
import com.spearhead.nova.model.FundRedemption;
import com.spearhead.nova.model.FundSubscription;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.repository.CreateFundRepository;
import com.spearhead.nova.repository.FundRepository;
import com.spearhead.nova.repository.FundSubscriptionRepository;
import com.spearhead.nova.repository.fundRedemptionRepository;
import com.spearhead.nova.service.FundService;
import com.spearhead.nova.util.MethodUtils;

@Service
public class fundImpl implements FundService {
	@Autowired
	private FundRepository fundRepository;
	
	@Autowired
	private fundRedemptionRepository fundredemptionRepo;

	@Autowired
	private FundSubscriptionRepository fundSubscriptionRepo;
	
	@Autowired
	private CreateFundRepository createFundRepo;


	@Override
	public ResponseEntity<StandardResponse> saveFunds(Fund fund) {
		// TODO Auto-generated method stub
		StandardResponse sr = new StandardResponse();
		 fundRepository.save(fund);
		
		sr.setStatus(true);
		sr.setStatuscode("200");
		sr.setMessage("Fund Save");
		return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
	}





	@Override
	public List<Fund> getFunds() {
		// TODO Auto-generated method stub
		return fundRepository.findAll();
	}





	@Override
	public ResponseEntity<StandardResponse> doredemption(FundRedemption fundRedemption) {
		// TODO Auto-generated method stub
		
		StandardResponse sr = new StandardResponse();
		fundredemptionRepo.save(fundRedemption);
		
		sr.setStatus(true);
		sr.setStatuscode("200");
		sr.setMessage("Do Redemption");
		return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		
	}





	@Override
	public ResponseEntity<StandardResponse> dosubscription(FundSubscription fundSubscription) {
		// TODO Auto-generated method stub
		StandardResponse sr = new StandardResponse();
		fundSubscriptionRepo.save(fundSubscription);
		
		sr.setStatus(true);
		sr.setStatuscode("200");
		sr.setMessage("Do Subscription");
		return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		//return null;
	}





	@Override
	public ResponseEntity<StandardResponse> doFundAccount(CreateFundAccount createFundAccount) {
		// TODO Auto-generated method stub
		StandardResponse sr = new StandardResponse();
		createFundRepo.save(createFundAccount);
		
		sr.setStatus(true);
		sr.setStatuscode("200");
		sr.setMessage("Create Mutual Fund");
		return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		//return null;
	}










	





	
	
}

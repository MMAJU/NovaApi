package com.spearhead.nova.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.spearhead.nova.model.CreateFundAccount;
import com.spearhead.nova.model.Fund;
import com.spearhead.nova.model.FundRedemption;
import com.spearhead.nova.model.FundSubscription;
import com.spearhead.nova.model.StandardResponse;

public interface FundService {

	

//	ResponseEntity<String> getFunds();



	ResponseEntity<StandardResponse> saveFunds(Fund fund);

	List<Fund> getFunds();

	ResponseEntity<StandardResponse> doredemption(FundRedemption fundRedemption);

	ResponseEntity<StandardResponse> dosubscription(FundSubscription fundSubscription);

	ResponseEntity<StandardResponse> doFundAccount(CreateFundAccount createFundAccount);

	




	

}

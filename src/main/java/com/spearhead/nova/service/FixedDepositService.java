package com.spearhead.nova.service;

import java.util.List;

import com.spearhead.nova.model.FixedDeposit;

public interface FixedDepositService {

	FixedDeposit getPlacementByCustomerId(String customerId);

	List<FixedDeposit> getPlacementByPlacementId(String placementId);

	//FixedDeposit getPlacementByPlacementId(String placementId);

	



	

}

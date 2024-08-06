package com.spearhead.nova.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spearhead.nova.model.FixedDeposit;
import com.spearhead.nova.repository.FixedDepositRepository;
import com.spearhead.nova.service.FixedDepositService;

@Service
public class FixedDepositImpl implements FixedDepositService {
	@Autowired
	private FixedDepositRepository fixedDepoRepo;

	@Override
	public FixedDeposit getPlacementByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return fixedDepoRepo.findByCustomerId(customerId).get();
	}

	@Override
	public List<FixedDeposit> getPlacementByPlacementId(String placementId) {
		// TODO Auto-generated method stub
		return fixedDepoRepo.findAllByPlacementId(placementId);
	}



	

	




}

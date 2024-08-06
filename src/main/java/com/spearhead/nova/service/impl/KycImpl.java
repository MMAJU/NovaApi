package com.spearhead.nova.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spearhead.nova.model.Kyc;
import com.spearhead.nova.repository.KycRepository;
import com.spearhead.nova.service.KycService;

@Service
public class KycImpl implements KycService {
	@Autowired
	private KycRepository kycRepository;

	@Override
	public Kyc saveKyc(Kyc kyc) {
		// TODO Auto-generated method stub
		return kycRepository.save(kyc);
	}







}

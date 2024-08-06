package com.spearhead.nova.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.TopOffers;
import com.spearhead.nova.repository.TopOffersRepository;
import com.spearhead.nova.service.TopOffersService;
@Service
public class TopOffersImpl implements TopOffersService  {
	
	@Autowired
	private TopOffersRepository topOffersRepo;

	@Override
	public ResponseEntity<StandardResponse> saveTopOffers(TopOffers topOffers) {
		// TODO Auto-generated method stub
		StandardResponse sr = new StandardResponse();
		sr.setStatus(true);
		sr.setStatuscode("200");
		sr.setMessage("Top Losers Have been Succesfully Saved");
		topOffersRepo.save(topOffers);
	    return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
	}

	@Override
	public List<TopOffers> getTopOffers() {
		// TODO Auto-generated method stub
		return topOffersRepo.findAll();
	}
	

}

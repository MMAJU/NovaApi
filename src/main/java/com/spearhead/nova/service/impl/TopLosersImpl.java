package com.spearhead.nova.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spearhead.nova.model.Fund;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.TopLosers;
import com.spearhead.nova.repository.TopLosersRespository;
import com.spearhead.nova.service.TopLosersService;

@Service
public class TopLosersImpl implements TopLosersService {
	@Autowired
	private TopLosersRespository topLoserRepo;

	@Override
	public ResponseEntity<StandardResponse> saveTopLosers(TopLosers topLosers) {
		// TODO Auto-generated method stub
		StandardResponse sr = new StandardResponse();
		sr.setStatus(true);
		sr.setStatuscode("200");
		sr.setMessage("Top Losers Have been Succesfully Saved");
		topLoserRepo.save(topLosers);
	    return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
	}

	@Override
	public List<TopLosers> getAllTopLosers() {
		// TODO Auto-generated method stub
		return topLoserRepo.findAll();
	}




	
}

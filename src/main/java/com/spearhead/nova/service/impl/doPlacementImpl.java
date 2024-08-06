package com.spearhead.nova.service.impl;

import com.spearhead.nova.model.DoPlacement;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.repository.placementRepo;
import com.spearhead.nova.service.doPlacementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class doPlacementImpl implements doPlacementService {


    @Autowired
	private placementRepo placementrepo;

    @Override
    public ResponseEntity<StandardResponse> savePlacement(DoPlacement doPlacement) {
        // TODO Auto-generated method stub
        StandardResponse sr = new StandardResponse();
		sr.setStatus(true);
		sr.setStatuscode("200");
		sr.setMessage("Do Placement Succesfull");
        placementrepo.save(doPlacement);
		 return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
    }
    
}

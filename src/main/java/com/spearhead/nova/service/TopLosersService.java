package com.spearhead.nova.service;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.TopLosers;

public interface TopLosersService {

	ResponseEntity<StandardResponse> saveTopLosers(TopLosers topLosers);

	List<TopLosers> getAllTopLosers();

	

	

}

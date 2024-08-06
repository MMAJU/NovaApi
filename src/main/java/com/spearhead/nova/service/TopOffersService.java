package com.spearhead.nova.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.TopOffers;

public interface TopOffersService {

	ResponseEntity<StandardResponse> saveTopOffers(TopOffers topOffers);

	List<TopOffers> getTopOffers();

}

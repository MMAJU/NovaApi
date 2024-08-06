package com.spearhead.nova.service;

import com.spearhead.nova.model.DoPlacement;
import com.spearhead.nova.model.StandardResponse;

import org.springframework.http.ResponseEntity;

public interface doPlacementService {

     ResponseEntity<StandardResponse> savePlacement(DoPlacement doPlacement);
  
}

package com.spearhead.nova.resource;

import com.spearhead.nova.model.DoPlacement;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.service.doPlacementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
    "Fixed Deposit" }, description = "Rest APIs that Returns Mutual Funds")
    @RestController
    @RequestMapping("/api/fixeddeposit")
public class DoPlacementController {

    @Autowired
    private doPlacementService doPlacementService;

   
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/doplacement")
 public ResponseEntity<StandardResponse>doplacement(@RequestBody DoPlacement doPlacement){
    return doPlacementService.savePlacement(doPlacement);
     
 }
    
}

package com.spearhead.nova.resource;

import com.spearhead.nova.model.SpecialRequest;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.service.SpecialRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
    "Special Request" }, description = "Rest APIs to Create Basic Setting")
    @RestController
@RequestMapping("/api/customerspecialrequest")
public class SpecialRequestController {

    @Autowired
	private SpecialRequestService specialRequestService;


    @PostMapping("/savespecialrequest")
    public ResponseEntity<StandardResponse> saveabout(@RequestBody SpecialRequest specialRequest) {
		try {
			Object data = specialRequestService.saveSpecialRequest(specialRequest);
			StandardResponse sr = new StandardResponse();
			sr.setData(data);
			sr.setMessage("Special Request Saved");
			sr.setStatus(true);
			sr.setStatuscode("200");
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		} catch (Exception e) {
			//TODO: handle exception
			StandardResponse sr = new StandardResponse();
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		
	}

	@ResponseStatus(HttpStatus.OK)
    @GetMapping("/getspecialrequest/{customerid}")
    public ResponseEntity<StandardResponse> getspecialrequestById(@PathVariable("customerid") String customerId) {
        return specialRequestService.getSpecialRequest(customerId);
        
    }
    
}

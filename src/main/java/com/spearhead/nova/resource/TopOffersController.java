package com.spearhead.nova.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.TopLosers;
import com.spearhead.nova.model.TopOffers;
import com.spearhead.nova.service.TopOffersService;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
"Stock Price" }, description = "Rest APIs that Returns Stock Price")
@RestController
@RequestMapping("/api/topoffers")
public class TopOffersController {
	
	@Autowired
	private TopOffersService topOfferService;
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/savestopoffers")
 public ResponseEntity<StandardResponse> saveTopOffers(@RequestBody TopOffers topOffers){
	return topOfferService.saveTopOffers(topOffers);
	 
 }
	
	 @ResponseStatus(HttpStatus.OK)
	 @GetMapping("/gettopoffers")
	 public ResponseEntity<StandardResponse>  getTopOffers(){
			

			try {

				Object data = topOfferService.getTopOffers();
		 
				 StandardResponse sr = new StandardResponse();
				 sr.setData(data);
				 sr.setMessage("Get Top Offers");
				 sr.setStatus(true);
				 sr.setStatuscode("200");
				 
		 
				   return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
			   } catch (Exception e) {
				   //TODO: handle exception
				   StandardResponse sr = new StandardResponse();
				   sr.setStatus(false);
				   return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
			  }
			 
		 }

}

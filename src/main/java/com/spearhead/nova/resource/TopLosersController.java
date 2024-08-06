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

import com.spearhead.nova.model.Fund;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.StockPrice;
import com.spearhead.nova.model.TopLosers;
import com.spearhead.nova.service.TopLosersService;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
"Stock Price" }, description = "Rest APIs that Returns Stock Price")
@RestController
@RequestMapping("/api/toplosers")
public class TopLosersController {
	@Autowired
	 private  TopLosersService topLosersService;
	
	 @ResponseStatus(HttpStatus.OK)
		@PostMapping("/savestoploser")
	 public ResponseEntity<StandardResponse> saveTopLosers(@RequestBody TopLosers topLosers){
		return topLosersService.saveTopLosers(topLosers);
		 
	 }
	 
	 @ResponseStatus(HttpStatus.OK)
	 @GetMapping("/gettoplosers")
	 public ResponseEntity<StandardResponse> getAllTopLosers(){
	

		
		try {

			Object data = topLosersService.getAllTopLosers();
	 
			 StandardResponse sr = new StandardResponse();
			 sr.setData(data);
			 sr.setMessage("Get Top Loser");
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

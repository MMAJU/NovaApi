package com.spearhead.nova.resource;

import org.codehaus.jettison.json.JSONException;
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

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.StockPrice;
import com.spearhead.nova.service.StockPriceService;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
"Stock Price" }, description = "Rest APIs that Returns Stock Price")
@RestController
@RequestMapping("/api/stockprice")
public class StockPriceController {

	
	 @Autowired
	 private StockPriceService stockPriceService;
	 
	 @ResponseStatus(HttpStatus.OK)
		@PostMapping("/savestockprice")
	 public ResponseEntity<StandardResponse> saveStockPrice(@RequestBody StockPrice stockPrice){
		return stockPriceService.saveStockPrice(stockPrice);
		 
	 }
	 
	 @ResponseStatus(HttpStatus.OK)
	 @GetMapping("/getstockprice/{symbolcode}")
	 public ResponseEntity<StandardResponse> getStockPrice(@PathVariable("symbolcode") String symbolCode) {
		
		try {

			Object data = stockPriceService.getStockPrice(symbolCode);
	 
			 StandardResponse sr = new StandardResponse();
			 sr.setData(data);
			 sr.setMessage("Get Fund Port folio");
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

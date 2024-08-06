package com.spearhead.nova.resource;

import java.util.List;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.Stocks;
import com.spearhead.nova.service.StocksService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
    "Stock Price" }, description = "Rest APIs that Returns Stock Price")
    @RestController
    @RequestMapping("/api/stocks")

public class StocksController {

    @Autowired
    private StocksService stockService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAllStocks")
    public ResponseEntity<StandardResponse> getAllStocks(){



        try {

			Object data = stockService.getAllStocks();
	 
			 StandardResponse sr = new StandardResponse();
			 sr.setData(data);
			 sr.setMessage("Get All Stocks");
			 sr.setStatus(true);
			 sr.setStatuscode("200");
			 
	 
			   return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		   } catch (Exception e) {
			   //TODO: handle exception
			   StandardResponse sr = new StandardResponse();
			   sr.setStatus(false);
			   return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		  }

        //return stockService.getAllStocks();
        
    }


	@ResponseStatus(HttpStatus.OK)
    @GetMapping("/getStockById")
	public ResponseEntity<StandardResponse> getStockById(){



        try {

			Object data = stockService.getAllStocks();
	 
			 StandardResponse sr = new StandardResponse();
			 sr.setData(data);
			 sr.setMessage("Get All Stocks");
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
	

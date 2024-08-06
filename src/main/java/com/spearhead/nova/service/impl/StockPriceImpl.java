package com.spearhead.nova.service.impl;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.StockPrice;
import com.spearhead.nova.repository.StockPriceRepository;
import com.spearhead.nova.service.StockPriceService;
import com.spearhead.nova.util.MethodUtils;

@Service
public class StockPriceImpl implements StockPriceService{
	
	@Autowired
	private StockPriceRepository stockPriceRepo;

	@Override
	public ResponseEntity<StandardResponse> saveStockPrice(StockPrice stockPrice) {
		// TODO Auto-generated method stub
		StandardResponse sr = new StandardResponse();
		sr.setStatus(true);
		sr.setStatuscode("200");
		sr.setMessage("Stock Have been Succesfully Saved");
		stockPriceRepo.save(stockPrice);
	    return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
	}

	@Override
	public StockPrice getStockPrice(String symbolCode) {
		// TODO Auto-generated method stub
		
		
////		JSONObject jsonObject = new JSONObject();
//		StockPrice stockPrice = stockPriceRepo.findBySymbolCode(symbolCode).get();
//		JSONObject apiResponse = new JSONObject(stockPrice);
//		JSONObject response = apiResponse.getJSONObject("data");
//		
//		jsonObject.put("Get Stock", new JSONObject(stockPrice.toString()));
//		return new ResponseEntity<String>(MethodUtils.prepareResponseJSON(HttpStatus.OK, jsonObject.toString()),  HttpStatus.OK);
		  //return ResponseEntity.ok().body(apiResponse.toString());
		return stockPriceRepo.findBySymbolCode(symbolCode).get();
	}

}

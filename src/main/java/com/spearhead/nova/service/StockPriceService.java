package com.spearhead.nova.service;


import org.json.JSONException;
import org.springframework.http.ResponseEntity;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.StockPrice;

public interface StockPriceService {

	ResponseEntity<StandardResponse> saveStockPrice(StockPrice stockPrice);

	StockPrice getStockPrice(String symbolCode) ;

}

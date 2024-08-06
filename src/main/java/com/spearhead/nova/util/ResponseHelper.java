package com.spearhead.nova.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.spearhead.nova.model.pojoClasses.GeneralSymplusResponse;

public class ResponseHelper {

   public static Map<String, Object> extractDataMethod(ResponseEntity<GeneralSymplusResponse> resultr) {
		Map<String, Object> data = new HashMap<>();
// ArrayList<GetFund> GetFund = new ArrayList<GetFund>();
//We can determin Response that will be displayed 
for (Map<String, ArrayList<Map<String, Object> > > funds : resultr.getBody().getResult()) {
 for ( Map<String, Object> fund  : funds.get("GetFunds")){
			data.put("Description", fund.get("FUND_DESCRIPTION"));
			data.put("Date of Value", fund.get("VALUE_DATE"));
 }
}
		return data;
	}
    
}

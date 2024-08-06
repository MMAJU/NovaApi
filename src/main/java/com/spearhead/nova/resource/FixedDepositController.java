package com.spearhead.nova.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spearhead.nova.model.FixedDeposit;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.pojoClasses.GeneralSymplusResponse;
import com.spearhead.nova.service.FixedDepositService;
import com.spearhead.nova.util.ValidateEntity;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
"Fixed Deposit" }, description = "Rest APIs that Returns Information Corncering the Fixed Deposit")
@RestController
@RequestMapping("/api/fixeddespoit")
public class FixedDepositController {
	
	
	 @Autowired
	 private FixedDepositService fixedDepositService;

	 @Value("${spearhead.symplusservice}")
	 private  String baseDevURL;

	 RestTemplate restTemplate;
	
	 @ResponseStatus(HttpStatus.OK)
	 @GetMapping("/getplacement/{customerid}")

	 private  Map<String, Object> extractDataMethod(ResponseEntity<GeneralSymplusResponse> resultr) {
		Map<String, Object> data = new HashMap<>();
//loop through Get Fund Array and display item you want
for (Map<String, ArrayList<Map<String, Object> > > funds : resultr.getBody().getResult()) {
 for ( Map<String, Object> fund  : funds.get("GetPlacement")){
	data.put("Fund Id ", fund.get("FUND_ID"));
	data.put("Fund Description", fund.get("FUND_DESCRIPTION"));
	data.put("Fund Description", fund.get("FUND_DESCRIPTION"));
	data.put("Product", fund.get("PRODUCT_ID"));
	data.put("Product Description", fund.get("PRODUCT_DESC"));
	data.put("Customer Name", fund.get("CUSTOMER_NAME"));
 }
}
		return data;
	}
	 
	 public ResponseEntity <StandardResponse>  getPlacementByCustomerId(@PathVariable("customerid") String customerId)
	 throws URISyntaxException  {
		String path = baseDevURL + "/GetAMTBillOrders/" + customerId;
		StandardResponse sr = new StandardResponse();
		HttpEntity<String> entity = ValidateEntity.getentity("");
		try {
			URI uri = new URI(path);
			ResponseEntity<GeneralSymplusResponse> resultr = restTemplate.exchange(uri, HttpMethod.GET, entity, GeneralSymplusResponse.class);
			
			if(!resultr.getBody().getStatus().equalsIgnoreCase("success")){
				sr.setStatus(false);
				return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
			}

			Map<String, Object> data = extractDataMethod(resultr);
			//Object data = fixedDepositService.getPlacementByCustomerId(customerId);
	 
			 
			 sr.setData(data);
			 sr.setMessage("Get Placement");
			 sr.setStatus(true);
			 sr.setStatuscode("200");
			 
	 
			   return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		   } catch (Exception e) {
			   //TODO: handle exception
			 
			   sr.setStatus(false);
			   return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		  }
		
		 
	 }
	 
	 
		
////	 @ResponseStatus(HttpStatus.OK)
//	 @GetMapping("/getplacements/{placementid}")
//	 public FixedDeposit getPlacementByPlacementId(@PathVariable("placementid") String placementId) {
//			return fixedDepositService.getPlacementByPlacementId(placementId);
//			 
//		 }
	 
	 @ResponseStatus(HttpStatus.OK)
	 @GetMapping("/getplacements/{placementid}")
	 public List<FixedDeposit> getPlacementByPlacementId(@PathVariable("placementid") String placementId){
		return fixedDepositService.getPlacementByPlacementId(placementId);		 
	 }

}

package com.spearhead.nova.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.common.hash.Hashing;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.pojoClasses.GeneralSymplusResponse;
import com.spearhead.nova.model.pojoClasses.Tbillliq;
import com.spearhead.nova.model.pojoClasses.TbillliqRequest;
import com.spearhead.nova.util.ValidateEntity;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
        "Client Trade " }, description = "Rest APIs that Returns Information Corncering the Customer")
@RestController
@RequestMapping("/api/clientTrade")

public class ClientTradeController {

    @Autowired
    private GetKeyContoller getKeyContoller;

    @Autowired
    // // Using Rest Template to consume external endpoint
    RestTemplate restTemplate;

       @Value("${spearhead.clientkey}")
        private String ClientKey;

        @Value("${spearhead.privatekey}")
        private String PrivateKey;

        @Value("${spearhead.symplusservice}")
        private  String baseDevURL;


    @GetMapping("/getAmtBill")
    public ResponseEntity<StandardResponse> getAmtBill() throws URISyntaxException {
        String path = baseDevURL + "/GetAMTBillProducts/";
		StandardResponse sr = new StandardResponse();
 
        HttpEntity<String> entity = ValidateEntity.getentity("");
		try {
        URI uri = new URI(path);

		ResponseEntity<GeneralSymplusResponse> resultr = restTemplate.exchange(uri, HttpMethod.GET, entity, GeneralSymplusResponse.class);
		
		if(!resultr.getBody().getStatus().equalsIgnoreCase("success")){
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}

		//Map<String, Object> data = extractDataMethod(resultr);
		Map<String, Object> data = new HashMap<>();
		for (Map<String, ArrayList<Map<String, Object> > > funds : resultr.getBody().getResult()) {
			for ( Map<String, Object> fund  : funds.get("GetFunds")){
					   data.put("Description", fund.get("FUND_DESCRIPTION"));
					   data.put("Date of Value", fund.get("VALUE_DATE"));
			}
		   }

		sr.setData(data);
		sr.setMessage("Result");
		sr.setStatus(true);
		sr.setStatuscode("200");
		return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
			
			// JSONObject apiResponse = new JSONObject(resultr);
            // JSONArray Result = apiResponse.getJSONArray("result");
			// sr.setData(Result);
			// sr.setMessage("Result");
			// sr.setStatus(true);
			// sr.setStatuscode("200");
			// return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		
		} catch (Exception e) {
			//TODO: handle exception
			
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
    
        //return resultr;

    }


    @GetMapping("/getAmtBillOrders/{customerid}")
    public ResponseEntity<StandardResponse> getAmtBillOrders(@PathVariable("customerid") String customerid)
            throws URISyntaxException {
        String path = baseDevURL + "/GetAMTBillOrders/" + customerid;
	    StandardResponse sr = new StandardResponse();
        HttpEntity<String> entity = ValidateEntity.getentity("");


		try {
        URI uri = new URI(path);

		ResponseEntity<GeneralSymplusResponse> resultr = restTemplate.exchange(uri, HttpMethod.GET, entity, GeneralSymplusResponse.class);
        //ResponseEntity<String> resultr = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

		if(!resultr.getBody().getStatus().equalsIgnoreCase("success")){
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
        
		Map<String, Object> data = new HashMap<>();
		for (Map<String, ArrayList<Map<String, Object> > > funds : resultr.getBody().getResult()) {
			for ( Map<String, Object> fund  : funds.get("GetFunds")){
					   data.put("Description", fund.get("FUND_DESCRIPTION"));
					   data.put("Date of Value", fund.get("VALUE_DATE"));
			}
		   }

		sr.setData(data);
		sr.setMessage("Result");
		sr.setStatus(true);
		sr.setStatuscode("200");
		return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		
		} catch (Exception e) {
			//TODO: handle exception
		
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
    

    }

    @GetMapping("/getAmtBillOrder/{customerid}/{orderno}")
    public ResponseEntity<StandardResponse> getAmtBillOrder(@PathVariable("customerid") String customerid,
            @PathVariable("orderno") String orderno)
            throws URISyntaxException {
        String path = baseDevURL + "/GetAMTBillOrder/" + customerid + "/" + orderno;
	    StandardResponse sr = new StandardResponse();

        HttpEntity<String> entity = ValidateEntity.getentity("");

		try {
        URI uri = new URI(path);

		ResponseEntity<GeneralSymplusResponse> resultr = restTemplate.exchange(uri, HttpMethod.GET, entity, GeneralSymplusResponse.class);
			
		if(!resultr.getBody().getStatus().equalsIgnoreCase("success")){
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		Map<String, Object> data = new HashMap<>();
		for (Map<String, ArrayList<Map<String, Object> > > funds : resultr.getBody().getResult()) {
			for ( Map<String, Object> fund  : funds.get("GetFunds")){
					   data.put("Description", fund.get("FUND_DESCRIPTION"));
					   data.put("Date of Value", fund.get("VALUE_DATE"));
			}
		   }

			sr.setData(data);
			sr.setMessage("Result");
			sr.setStatus(true);
			sr.setStatuscode("200");
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		
		} catch (Exception e) {
			//TODO: handle exception
		
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
    

    }

    @GetMapping("/getAmtBillOrderCash/{customerid}/{productid}")
    public ResponseEntity<StandardResponse> getAmtBillOrderCash(@PathVariable("customerid") String customerid,
            @PathVariable("orderno") String productid)
            throws URISyntaxException {
        String path = baseDevURL + "/GetAMTBillCashAccounts/" + customerid + "/" + productid;
  
        HttpEntity<String> entity = ValidateEntity.getentity("");
		StandardResponse sr = new StandardResponse();
		
		try {
        URI uri = new URI(path);

        ResponseEntity<GeneralSymplusResponse> resultr = restTemplate.exchange(uri, HttpMethod.GET, entity, GeneralSymplusResponse.class);
		if(!resultr.getBody().getStatus().equalsIgnoreCase("success")){
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		Map<String, Object> data = new HashMap<>();
		for (Map<String, ArrayList<Map<String, Object> > > funds : resultr.getBody().getResult()) {
			for ( Map<String, Object> fund  : funds.get("GetFunds")){
					   data.put("Description", fund.get("FUND_DESCRIPTION"));
					   data.put("Date of Value", fund.get("VALUE_DATE"));
			}
		   }
			
		   sr.setData(data);
		   sr.setMessage("Result");
		   sr.setStatus(true);
		   sr.setStatuscode("200");
		   return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		
		} catch (Exception e) {
			//TODO: handle exception
		
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}

    }

    @GetMapping("/getAmtBillActive/{customerid}")
    public ResponseEntity<StandardResponse> getAmtBillActive(@PathVariable("customerid") String customerid)
            throws URISyntaxException {
        String path = baseDevURL + "/GetAMTBillActive/" + customerid;
		StandardResponse sr = new StandardResponse();
        HttpEntity<String> entity = ValidateEntity.getentity("");

		try {
        URI uri = new URI(path);

        ResponseEntity<GeneralSymplusResponse> resultr = restTemplate.exchange(uri, HttpMethod.GET, entity, GeneralSymplusResponse.class);
        //return resultr;
		if(!resultr.getBody().getStatus().equalsIgnoreCase("success")){
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		Map<String, Object> data = new HashMap<>();
		for (Map<String, ArrayList<Map<String, Object> > > funds : resultr.getBody().getResult()) {
			for ( Map<String, Object> fund  : funds.get("GetFunds")){
					   data.put("Description", fund.get("FUND_DESCRIPTION"));
					   data.put("Date of Value", fund.get("VALUE_DATE"));
			}
		   }
        
			
		   sr.setData(data);
		   sr.setMessage("Result");
		   sr.setStatus(true);
		   sr.setStatuscode("200");
		   return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		} catch (Exception e) {
			//TODO: handle exception
		
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}

    }

    @GetMapping("/getAmtBillMature/{customerid}")
    public ResponseEntity<StandardResponse> getAmtBillMature(@PathVariable("customerid") String customerid)
            throws URISyntaxException {
        String path = baseDevURL + "/GetAMTBillMatured/" + customerid;
		StandardResponse sr = new StandardResponse();
 

        HttpEntity<String> entity = ValidateEntity.getentity("");
		try {
        URI uri = new URI(path);

		ResponseEntity<GeneralSymplusResponse> resultr = restTemplate.exchange(uri, HttpMethod.GET, entity, GeneralSymplusResponse.class);
        //return resultr;
		if(!resultr.getBody().getStatus().equalsIgnoreCase("success")){
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		Map<String, Object> data = new HashMap<>();
		for (Map<String, ArrayList<Map<String, Object> > > funds : resultr.getBody().getResult()) {
			for ( Map<String, Object> fund  : funds.get("GetFunds")){
					   data.put("Description", fund.get("FUND_DESCRIPTION"));
					   data.put("Date of Value", fund.get("VALUE_DATE"));
			}
		   }
       
			
		   sr.setData(data);
		   sr.setMessage("Result");
		   sr.setStatus(true);
		   sr.setStatuscode("200");
		   return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		
		} catch (Exception e) {
			//TODO: handle exception
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}

    }

    @GetMapping("/getAmtBillSellable/{customerid}")
    public ResponseEntity<StandardResponse> getAmtBillSellable(@PathVariable("customerid") String customerid)
            throws URISyntaxException {
        String path = baseDevURL + "GetAMTBillSellable/" + customerid;
		StandardResponse sr = new StandardResponse();
      
        HttpEntity<String> entity = ValidateEntity.getentity("");
		try {
        URI uri = new URI(path);

        ResponseEntity<GeneralSymplusResponse> resultr = restTemplate.exchange(uri, HttpMethod.GET, entity, GeneralSymplusResponse.class);

        //return resultr;
		if(!resultr.getBody().getStatus().equalsIgnoreCase("success")){
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		Map<String, Object> data = new HashMap<>();
		for (Map<String, ArrayList<Map<String, Object> > > funds : resultr.getBody().getResult()) {
			for ( Map<String, Object> fund  : funds.get("GetFunds")){
					   data.put("Description", fund.get("FUND_DESCRIPTION"));
					   data.put("Date of Value", fund.get("VALUE_DATE"));
			}
		   }
			
		   sr.setData(data);
		   sr.setMessage("Result");
		   sr.setStatus(true);
		   sr.setStatuscode("200");
		   return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		
		} catch (Exception e) {
			//TODO: handle exception
		
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
    }

    @PostMapping("/doAtmBillLiquidate")
    public ResponseEntity<StandardResponse> doAtmBillLiquidate(@RequestBody TbillliqRequest tbillliqRequest)
            throws URISyntaxException {

        HttpEntity<String> entity = ValidateEntity.getentity(tbillliqRequest.toString());
        String path = baseDevURL + "/DoAMTBillLiquidate/";
		StandardResponse sr = new StandardResponse();
		try {
        URI uri = new URI(path);
		ResponseEntity<GeneralSymplusResponse> resultr = restTemplate.exchange(uri, HttpMethod.GET, entity, GeneralSymplusResponse.class);

        //return resultr;
		if(!resultr.getBody().getStatus().equalsIgnoreCase("success")){
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		Map<String, Object> data = new HashMap<>();
		for (Map<String, ArrayList<Map<String, Object> > > funds : resultr.getBody().getResult()) {
			for ( Map<String, Object> fund  : funds.get("GetFunds")){
					   data.put("Description", fund.get("FUND_DESCRIPTION"));
					   data.put("Date of Value", fund.get("VALUE_DATE"));
			}
		   }
       
			
		   sr.setData(data);
		   sr.setMessage("Result");
		   sr.setStatus(true);
		   sr.setStatuscode("200");
		   return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		
		} catch (Exception e) {
			//TODO: handle exception
		
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
    }

}

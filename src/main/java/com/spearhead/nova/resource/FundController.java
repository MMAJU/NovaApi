package com.spearhead.nova.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.common.hash.Hashing;
import com.spearhead.nova.model.CreateFundAccount;
import com.spearhead.nova.model.Fund;
import com.spearhead.nova.model.FundRedemption;
import com.spearhead.nova.model.FundSubscription;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.User;
import com.spearhead.nova.model.pojoClasses.GeneralSymplusResponse;
import com.spearhead.nova.model.pojoClasses.GetFund;
import com.spearhead.nova.model.pojoClasses.GetFunds;
import com.spearhead.nova.service.FundService;
import com.spearhead.nova.util.ResponseHelper;
import com.spearhead.nova.util.ValidateEntity;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
		"Mutual Funds" }, description = "Rest APIs that Returns Mutual Funds")
@RestController
@RequestMapping("/api/mutualfunds")
public class FundController {

	@Autowired
	private FundService fundService;

	@Autowired
	private GetKeyContoller getKeyContoller;

	@Autowired
	// // Using Rest Template to consume external endpoint
	RestTemplate restTemplate;

	@Value("${spearhead.clientkey}")
    private String ClientKey;

    @Value("${spearhead.privatekey}")
    private String PrivateKey;

    @Value("${spearhead.basedevurl}")
    private  String baseDevURL;


	private  Map<String, Object> extractDataMethod(ResponseEntity<GeneralSymplusResponse> resultr) {
		Map<String, Object> data = new HashMap<>();
		System.out.println("I got Here ......");
//loop through Get Fund Array and display item you want
for (Map<String, ArrayList<Map<String, Object> > > funds : resultr.getBody().getResult()) {
 for ( Map<String, Object> fund  : funds.get("GetFunds")){
			data.put("Fund ID", fund.get("FUND_ID"));
			data.put("Description", fund.get("FUND_DESCRIPTION"));
			data.put("Currency", fund.get("FUND_CURRENCY"));
			data.put("Type of Fund", fund.get("FUND_TYPE"));
			//data.put("Date Opened", fund.get("DATE_OPENED"));
 }
}
		return data;
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/savefunds")
	public ResponseEntity<StandardResponse> saveFunds(@RequestBody Fund fund) {
		return fundService.saveFunds(fund);

	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/doredemption")
	public ResponseEntity<StandardResponse> doRedemption(@RequestBody FundRedemption fundRedemption) {
		return fundService.doredemption(fundRedemption);

	}

	//
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/dofundaccount")
	public ResponseEntity<StandardResponse> doFundAccount(@RequestBody CreateFundAccount createFundAccount) {
		return fundService.doFundAccount(createFundAccount);

	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/dosubscription")
	public ResponseEntity<StandardResponse> doSubscription(@RequestBody FundSubscription fundSubscription) {
		return fundService.dosubscription(fundSubscription);

	}

	
	@GetMapping("/getfunds")
	public ResponseEntity<StandardResponse> getMyFunds() throws URISyntaxException {
		
		StandardResponse sr = new StandardResponse();
		HttpEntity<String> entity = ValidateEntity.getentity("");

	
		String path = baseDevURL + "GetFund/getGetFunds";
		//System.out.println("path is ...." + path + " entity ssssss " + entity) ;
		URI uri = new URI(path);
		ResponseEntity<GeneralSymplusResponse> resultr = restTemplate.exchange(uri, HttpMethod.GET, entity, GeneralSymplusResponse.class);
		System.out.println("testing Result for Status " + resultr) ;
		
	try {
	 System.out.println("Testing if you get here ...." + resultr.getBody().getStatus());
	 			if(!resultr.getBody().getStatus().equalsIgnoreCase("success")){
	 				sr.setStatus(false);
	 				return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
				}
				
					Map<String, Object> data = extractDataMethod(resultr);
					
			
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

package com.spearhead.nova.resource;

import org.codehaus.jettison.json.JSONException;
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

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.common.hash.Hashing;
import com.spearhead.nova.model.FundPortfolio;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.pojoClasses.GeneralSymplusResponse;
import com.spearhead.nova.service.FundPortfolioService;
import com.spearhead.nova.util.ValidateEntity;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
		"Mutual Funds" }, description = "Rest APIs that Returns Mutual Funds")
@RestController
@RequestMapping("/api/mutualfundsportfolio")
public class FundPortfolioController {

	@Autowired
	private FundPortfolioService fundPortfolioService;

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

	private  Map<String, Object> extractDataMethod(ResponseEntity<GeneralSymplusResponse> resultr) {
		Map<String, Object> data = new HashMap<>();
// ArrayList<GetFund> GetFund = new ArrayList<GetFund>();
//We can determin Response that will be displayed 
for (Map<String, ArrayList<Map<String, Object> > > funds : resultr.getBody().getResult()) {
 for ( Map<String, Object> fund  : funds.get("GetFundPortfolios")){
			data.put("Sperhead Content", fund.get("ACCOUNT_ID"));
			data.put("Spearhead Content2", fund.get("ACCOUNT_NAME"));
 }
}
		return data;
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/savefundportfolio")
	public ResponseEntity<StandardResponse> saveFunPortfolio(@RequestBody FundPortfolio fundPortfolio) {
		return fundPortfolioService.saveFunPortfolio(fundPortfolio);

	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/getfundportfolio/{customerid}")
	public ResponseEntity<StandardResponse> getfundportfolio(@PathVariable("customerid") String accountId) {

		try {

			Object data = fundPortfolioService.getFundPortfolio(accountId);

			StandardResponse sr = new StandardResponse();
			sr.setData(data);
			sr.setMessage("Get Fund Port folio");
			sr.setStatus(true);
			sr.setStatuscode("200");

			return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			StandardResponse sr = new StandardResponse();
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		}

	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/getMyfundportfolio/{customerid}")
	public ResponseEntity<StandardResponse> getMyfundportfolio(@PathVariable("customerid") String accountId)
			throws URISyntaxException {
		String path = baseDevURL + "/GetFundPortfolios/" + accountId + "/";
		StandardResponse sr = new StandardResponse();


		HttpEntity<String> entity = ValidateEntity.getentity("");

		try {
		URI uri = new URI(path);

		//ResponseEntity<String> resultr = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		ResponseEntity<GeneralSymplusResponse> resultr = restTemplate.exchange(uri, HttpMethod.GET, entity, GeneralSymplusResponse.class);
		
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

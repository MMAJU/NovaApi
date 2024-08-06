package com.spearhead.nova.resource;

import com.spearhead.nova.service.CashAccountService;
import com.spearhead.nova.util.ValidateEntity;
import com.spearhead.nova.util.PostResponseHelper;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.google.common.hash.Hashing;
import com.spearhead.nova.model.CashAccount;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.pojoClasses.CreateRequest;
import com.spearhead.nova.model.pojoClasses.DoCashRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
                "Customer Account" }, description = "Rest APIs that Returns Information Corncering the Customer Account")
@RestController
@RequestMapping("/api/customeraccount")
public class CashAccountController {

        @Autowired
        private CashAccountService cashAccountService;

        @Autowired
        private GetKeyContoller getKeyContoller;

        @Autowired
        RestTemplate restTemplate;

        @Value("${spearhead.clientkey}")
        private String ClientKey;

        @Value("${spearhead.privatekey}")
        private String PrivateKey;

        @Value("${spearhead.symplusservice}")
        private  String baseDevURL;


   

        // @ResponseStatus(HttpStatus.OK)
        // @PostMapping("/docashaccount")
        // public ResponseEntity<StandardResponse> docashaccount(@RequestBody CashAccount cashAccount) {
        //         return cashAccountService.docashaccount(cashAccount);

        // }

        @ResponseStatus(HttpStatus.OK)
        @PostMapping("/docashaccount")
        public ResponseEntity<StandardResponse> docashaccount(@RequestBody CreateRequest createRequest)
                        throws URISyntaxException {
   ;


            
                StandardResponse sr = new StandardResponse();
                String path = baseDevURL + "/DoCashAccount/";

                HttpEntity<String> entity = ValidateEntity.getentity(createRequest.toString());
                System.out.println("HTTP ENTITY: " + entity + "Path is " + path);
                URI uri = new URI(path);
                ResponseEntity<String> resultr = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
                System.out.println("Hello " + uri);

                // An utility class to check if post status is successul and return response
                return PostResponseHelper.postResponse(sr, resultr);
		
                

        }




        

}

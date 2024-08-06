package com.spearhead.nova.resource;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;

       


@Api(value = "User Endpoints", tags = {
        "Symplus Private Key" }, description = "Rest APIs that Gets Symplus Private Key")
@RestController
@RequestMapping("/api/symplusGetKey")
public class GetKeyContoller {
    @Autowired
    // // Using Rest Template to consume external endpoint
    RestTemplate restTemplate;

    @Value("${spearhead.clientkey}")
    private String ClientKey;

    @Value("${spearhead.privatekey}")
    private String PrivateKey;

    @Value("${spearhead.symplusservice}")
    private  String baseDevURL;

    @GetMapping("/TestingKey")
    public String getKey() {
        String uripath = baseDevURL + "/GetKey/"+ ClientKey + "/";
        String result = restTemplate.getForObject(uripath, String.class);
        JSONObject apiResponse = new JSONObject(result);
        String technology = apiResponse.getString("status");

        String PublicKey = apiResponse.getJSONArray("result").getJSONObject(0).getJSONArray("Security")
                .getJSONObject(0).getString("PublicKey");

    
        return PublicKey;
    }
}

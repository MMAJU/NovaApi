package com.spearhead.nova.util;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.google.common.hash.Hashing;
import com.spearhead.nova.resource.GetKeyContoller;

public class ValidateEntity {

    
    @Autowired
    private static GetKeyContoller getKeyContoller;

    @Value("${spearhead.clientkey}")
        private static String ClientKey;

        @Value("${spearhead.privatekey}")
        private static String PrivateKey;

        @Value("${spearhead.symplusservice}")
        private static String baseDevURL;


    public static HttpEntity<String> getentity(String urlcheck){

        // get the public key from the server using the Client Key
        //String PublicKey = getKeyContoller.getKey();
        
        //String Auth = PublicKey + ClientKey + PrivateKey;

        // String Authorization = Hashing.sha256()
        //              .hashString(Auth, StandardCharsets.UTF_8)
        //              .toString();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();

             headers.add("Content-Type", "application/json");
             headers.add("Accept", "application/json");
             //headers.add("Authorization-Key", Authorization);
            // headers.add("Client-Key", ClientKey);

        

        return new HttpEntity<String>(urlcheck, headers);
 }
    
}

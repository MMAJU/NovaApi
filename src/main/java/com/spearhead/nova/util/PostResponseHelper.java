package com.spearhead.nova.util;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.spearhead.nova.model.StandardResponse;

public class PostResponseHelper {


         // An utility class to check if post status is successul and return response
    public static ResponseEntity<StandardResponse> postResponse(StandardResponse sr, ResponseEntity<String> resultr) {
        try {
    
    JSONObject apiResponse = new JSONObject(resultr);
               
                if(!apiResponse.getString("status").equalsIgnoreCase("success")){
        sr.setStatus(false);
        return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
    }
                //Send All particular Response to user
    JSONObject Result = apiResponse.getJSONArray("result").getJSONObject(0).getJSONObject("reference");
                // Send All response to user
                //JSONObject Result = apiResponse.getJSONArray("result").getJSONObject(0);
             
    sr.setData(Result);
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

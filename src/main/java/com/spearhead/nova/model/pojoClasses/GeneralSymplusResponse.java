package com.spearhead.nova.model.pojoClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class GeneralSymplusResponse {

    // Get Initial Request
    private String status;
    private List<Map<String, ArrayList<Map<String, Object>>>> result;


    
    public String getStatus() {
        return status;
      
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public List<Map<String, ArrayList<Map<String, Object>>>> getResult() {
        return result;
    }
    public void setResult(List<Map<String, ArrayList<Map<String, Object>>>> result) {
        this.result = result;
    }
  
    
    public GeneralSymplusResponse(String status, List<Map<String, ArrayList<Map<String, Object>>>> result) {
        this.status = status;
        this.result = result;
    }


    public GeneralSymplusResponse() {
    }
        


}

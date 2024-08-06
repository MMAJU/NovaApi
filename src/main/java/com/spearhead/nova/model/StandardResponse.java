package com.spearhead.nova.model;

public class StandardResponse {

    private boolean status;
    private String statuscode;
    private String message;
    private Object data;

    public StandardResponse(){
        super();
    }   

    public StandardResponse(boolean isStatus , String message){
        
        this.status = isStatus;
        this.message = message;
        this.data = null;
    }

    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public String getStatuscode() {
        return statuscode;
    }
    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    
}

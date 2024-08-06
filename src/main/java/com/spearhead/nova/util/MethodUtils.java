package com.spearhead.nova.util;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.http.HttpStatus;

public class MethodUtils {

	private MethodUtils() {
	}

	public static String prepareResponseJSON(HttpStatus status, String data) {
		JSONObject responseJSON = new JSONObject();
		
		
		try {
			JSONObject dataObject = new JSONObject(data);
			
			responseJSON.put("status", !status.isError());
			responseJSON.put("status_code", status.value());
			responseJSON.put("message", "success");
			responseJSON.put("data", dataObject);
		} catch (JSONException e) {
			
			JSONArray dataObject;
			try {
				dataObject = new JSONArray(data);
				responseJSON.put("status", !status.isError());
				responseJSON.put("status_code", status.value());
				responseJSON.put("message", "success");
				responseJSON.put("data", dataObject);
				
				return responseJSON.toString();
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

			e.printStackTrace();
		}
		return responseJSON.toString();
	}
	
	public static String prepareErrorJSON(HttpStatus status, String error) {
		JSONObject errorJSON = new JSONObject();
		try {
			errorJSON.put("status", status.isError());
			errorJSON.put("status_code", status.value());
			errorJSON.put("message", status.getReasonPhrase().concat(": " + error));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return errorJSON.toString();
	}
}

package com.spearhead.nova.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.Terms;
import com.spearhead.nova.service.TermService;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
    "Basic Settings" }, description = "Rest APIs to Create Basic Setting")

@RestController
@RequestMapping("/api/basicsettings")
public class TermController {

	@Autowired
	private TermService termService;
	
	//@PostMapping("/savetermsandcondition")
//	public Terms saveTerms(@RequestBody Terms terms) {
//		try {
//		return termService.saveTerms(terms);
//		}catch(Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//		
//		return null;termService
//	}
	
@ResponseStatus(HttpStatus.OK)
@PostMapping("/saveterms")
public ResponseEntity<StandardResponse> saveterms(@RequestBody Terms terms) {
	try {
		Object data = termService.saveTerms(terms);
		StandardResponse sr = new StandardResponse();
		sr.setData(data);
		sr.setMessage("Terms Saved Saved");
		sr.setStatus(true);
		sr.setStatuscode("200");
		return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
	} catch (Exception e) {
		//TODO: handle exception
		StandardResponse sr = new StandardResponse();
		sr.setStatus(false);
		return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
	}
	
}

@ResponseStatus(HttpStatus.OK)
@GetMapping("/getterms")
public ResponseEntity<StandardResponse> fetchTerms(){
	try {
		Object data = termService.fetchTerms();
		StandardResponse sr = new StandardResponse();
		sr.setData(data);
		sr.setMessage("Get Terms");
		sr.setStatus(true);
		sr.setStatuscode("200");
		return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
	} catch (Exception e) {
		//TODO: handle exception
		StandardResponse sr = new StandardResponse();
		sr.setStatus(false);
		return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
	}

}


@ResponseStatus(HttpStatus.OK)
    @PutMapping("/editterms/{id}")
	public ResponseEntity<StandardResponse>  updateTerms(@PathVariable("id") Long  termsId, @RequestBody Terms terms) {
		try {
			Object data = termService.updateTerms(termsId, terms);
			StandardResponse sr = new StandardResponse();
			sr.setData(data);
			sr.setMessage("Update Terms");
			sr.setStatus(true);
			sr.setStatuscode("200");
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		} catch (Exception e) {
			//TODO: handle exception
			StandardResponse sr = new StandardResponse();
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		
	}

	@ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deleteterms/{id}")
	public ResponseEntity<StandardResponse> deleteabout(@PathVariable("id") Long termsId) {

		try {
			termService.deleteTerms(termsId);
			StandardResponse sr = new StandardResponse();
			
			sr.setMessage("Successfull Deletion");
			sr.setStatus(true);
			sr.setStatuscode("200");
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		} catch (Exception e) {
			//TODO: handle exception
			StandardResponse sr = new StandardResponse();
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		
	
	}
	
} 

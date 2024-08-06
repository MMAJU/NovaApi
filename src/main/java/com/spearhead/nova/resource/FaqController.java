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
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import com.spearhead.nova.model.Faq;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.service.FaqService;

@Api(value = "User Endpoints", tags = {
    "Basic Settings" }, description = "Rest APIs to Create Basic Setting")

@RestController
@RequestMapping("/api/basicsettings")
public class FaqController {
	
	@Autowired
	private FaqService faqService;
	
	@PostMapping("/savefaq")
	public ResponseEntity<StandardResponse> saveFaq(@RequestBody Faq faq) {
		try {
			Object data = faqService.saveFaq(faq);
			StandardResponse sr = new StandardResponse();
			sr.setData(data);
			sr.setMessage("Faq Save");
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
	
	@GetMapping("/getfaq")
	public ResponseEntity<StandardResponse> fetchFaq(){
		try {
			Object data = faqService.fetchFaq();
			StandardResponse sr = new StandardResponse();
			sr.setData(data);
			sr.setMessage("Get Frequently Asked Question");
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
	
	@PutMapping("/editdeletefaq/{id}")
	public ResponseEntity<StandardResponse>  updateFaq(@PathVariable("id") Long faqId, @RequestBody Faq faq) {
		try {
			Object data = faqService.updateFaq(faqId, faq);
			StandardResponse sr = new StandardResponse();
			sr.setData(data);
			sr.setMessage("Get Frequently Asked Question");
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
	@DeleteMapping("/editdeletefaq/{id}")
	public ResponseEntity<StandardResponse> deletefaq(@PathVariable("id") Long faqId) {

		try {
			faqService.deletefaq(faqId);
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

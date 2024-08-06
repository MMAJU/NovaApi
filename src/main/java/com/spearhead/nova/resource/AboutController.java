package com.spearhead.nova.resource;

import com.spearhead.nova.model.About;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.service.AboutService;


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

import io.swagger.annotations.Api;


@Api(value = "User Endpoints", tags = {
    "Basic Settings" }, description = "Rest APIs to Create Basic Setting")
    @RestController
@RequestMapping("/api/basicsettings")
public class AboutController {

    @Autowired
	private AboutService aboutService;



    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/saveabout")
    public ResponseEntity<StandardResponse> saveabout(@RequestBody About about) {
		try {
			Object data = aboutService.saveAbout(about);
			StandardResponse sr = new StandardResponse();
			sr.setData(data);
			sr.setMessage("About Us Saved");
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
    @GetMapping("/getabout")
	public ResponseEntity<StandardResponse> fetchAbout(){
		try {
			Object data = aboutService.fetchAbout();
			StandardResponse sr = new StandardResponse();
			sr.setData(data);
			sr.setMessage("Get About Us");
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
    @PutMapping("/editabout/{id}")
	public ResponseEntity<StandardResponse>  updateAbout(@PathVariable("id") Long  aboutId, @RequestBody About about) {
		try {
			Object data = aboutService.updateAbout(aboutId, about);
			StandardResponse sr = new StandardResponse();
			sr.setData(data);
			sr.setMessage("Update About Us");
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
    @DeleteMapping("/deleteabout/{id}")
	public ResponseEntity<StandardResponse> deleteabout(@PathVariable("id") Long aboutId) {

		try {
			aboutService.deleteAbout(aboutId);
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

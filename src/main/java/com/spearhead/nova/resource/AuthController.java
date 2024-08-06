package com.spearhead.nova.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.User;
import com.spearhead.nova.model.endpoint.ExistingCustomer;
import com.spearhead.nova.model.endpoint.SignOn;
import com.spearhead.nova.service.AuthService;
import com.spearhead.nova.service.impl.NotificationService;
import com.spearhead.nova.util.MethodUtils;






@Api(value = "Auth Controller", tags = {"Authentication"} , description = "Rest APIs that Manages the User Activities")
@RestController
@RequestMapping("/auth")
public class AuthController {

	

		
	@Autowired
	private AuthService authService;

	@Autowired
    NotificationService NService;

	

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/login")
	public ResponseEntity<String> authenticatUser(@RequestBody SignOn LoginInfo) throws Exception{
	
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("x-auth-token", "Here");
			// Use the SignOn to Get the user Information into User
		
			return authService.authenticate(LoginInfo);
	}


 	@ResponseStatus(HttpStatus.OK)
 	@PostMapping("/forgetpassword")
  public ResponseEntity<StandardResponse> forgetpassword( @RequestParam("email") String useremail) throws UnsupportedEncodingException, MessagingException{
 	return authService.forgetpassword (useremail);
	 
  }
	
	@PostMapping(value = "/registernewcustomer",  consumes="application/json", produces = "application/json")
	public ResponseEntity<StandardResponse> registerUser(@RequestBody User user) throws IllegalArgumentException {

		return authService.registerUser(user);
	}


	
	@PostMapping(value = "/testNotification",  consumes="application/json", produces = "application/json")
	public ResponseEntity<StandardResponse> testNotification(@RequestBody User user) throws IllegalArgumentException {

		NService.sendRegistrationNotification(user);
		
		return new ResponseEntity<StandardResponse>(new StandardResponse(true, "sent"), HttpStatus.OK);
		//if (response.late == "")
	}

	
	@PostMapping(value = "/registerexistingcustomer",  consumes="application/json", produces = "application/json")
	public ResponseEntity<StandardResponse> registerexistingcustomer(@RequestBody ExistingCustomer customer ) throws IllegalArgumentException {
		// Here we would consume the external API to populate the user details then we send the user an validation 

		// Call the API to fetch the Customer Details and Compare it

		User user = new User();
		user.setUsername("username");
		user.setPassword(customer.getPassword());
		user.setEmail("ralekeo@gmail.com");
		return authService.registerUser(user);
	}

	


		

	@ResponseStatus(HttpStatus.OK)
 	@PostMapping("/verifycode")
  public ResponseEntity<StandardResponse> verifyCode( @RequestParam("verificationOtp") String verificationOtp) {
 	return authService.verifyCode(verificationOtp);
	 
  }
	
	//@PostMapping(value = "/resetPassword", consumes="application/json", produces = "application/json")
	@PostMapping("/resetPassword")
	public ResponseEntity<StandardResponse> resetPassword(@RequestParam("password") String password, @RequestParam("email") String email) {
		
		//HttpHeaders responseHeaders = new HttpHeaders();
		return authService.resetpassword(password, email) ;

		
		
				
		// responseHeaders.set("x-auth-token", "Here");
		//return new ResponseEntity<String>(MethodUtils.prepareResponseJSON(HttpStatus.OK, "Returned Something"), HttpStatus.OK);
		
	}
	@ResponseStatus(HttpStatus.OK)
 	@PostMapping("/resendOtp")
  public ResponseEntity<StandardResponse> ResendOtp( @RequestParam("email") String useremail) throws UnsupportedEncodingException, MessagingException{
 	return authService.ResendOtp(useremail);
	 
  }
	
}

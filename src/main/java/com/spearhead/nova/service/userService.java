package com.spearhead.nova.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.spearhead.nova.model.Kyc;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.User;

public interface userService {

	List<User> fetchUserList();

	User fetchUserByCustomerId(String customerId);

	User updateUser(String customerId, User user);

    //User valateOTP(String oneTimePassword);

    User fetchByOneTimePassword(String oneTimePassword);

	User updateUserSignature(User user, HttpServletRequest request, String customerId, 
			MultipartFile[] extramultipartFile) throws IOException;

    User storeSignature(User user, String customerId, MultipartFile extramultipartFile) throws IOException;

	Object fetchByVerificationCode(String verificationOtp);

			



  // ResponseEntity<StandardResponse> fetchByOneTimePassword(String oneTimePassword);

	//ResponseEntity<User> fetchCustomerId(String customerId);


	

	
}

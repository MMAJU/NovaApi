package com.spearhead.nova.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
//import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.util.StringUtils;
import net.bytebuddy.utility.RandomString;

import org.apache.commons.lang3.ObjectUtils;

import com.spearhead.nova.model.Kyc;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.User;
import com.spearhead.nova.repository.UserRepository;
import com.spearhead.nova.resource.FileUploadUtil;
import com.spearhead.nova.service.userService;
import java.util.Objects;

@Service
public class userImpl implements userService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> fetchUserList() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	public User fetchUserByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return userRepository.findByCustomerId(customerId).get();
	}

	@Override
	public User updateUser(String customerId, User user) {
		// TODO Auto-generated method stub
		User userDB = userRepository.findByCustomerId(customerId).get();
		if(Objects.nonNull(user.getFirstName()) && !"".equalsIgnoreCase(user.getFirstName())) {
			userDB.setFirstName(user.getFirstName());
		}
		
		if(Objects.nonNull(user.getLastName()) && !"".equalsIgnoreCase(user.getLastName())) {
			userDB.setLastName(user.getLastName());
		}
		
		if(Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) {
			userDB.setEmail(user.getEmail());
		}
		
		if(Objects.nonNull(user.getPhoneNumber()) && !"".equalsIgnoreCase(user.getPhoneNumber())) {
			userDB.setPhoneNumber(user.getPhoneNumber());
		}
		
		if(Objects.nonNull(user.getStreetNumber()) && !"".equalsIgnoreCase(user.getStreetNumber())) {
			userDB.setStreetNumber(user.getStreetNumber());
		}
		
		if(Objects.nonNull(user.getStreetName()) && !"".equalsIgnoreCase(user.getStreetName())) {
			userDB.setStreetName(user.getStreetName());
		}
		
		if(Objects.nonNull(user.getCity()) && !"".equalsIgnoreCase(user.getCity())) {
			userDB.setCity(user.getCity());
		}
		
		if(Objects.nonNull(user.getCountry()) && !"".equalsIgnoreCase(user.getCountry())) {
			userDB.setCountry(user.getCountry());
		}
		if(Objects.nonNull(user.getNationality()) && !"".equalsIgnoreCase(user.getNationality())) {
			userDB.setNationality(user.getNationality());
		}
		if(Objects.nonNull(user.getBvn()) && !"".equalsIgnoreCase(user.getBvn())) {
			userDB.setBvn(user.getBvn());
		}
		if(Objects.nonNull(user.getKinFirstName()) && !"".equalsIgnoreCase(user.getKinFirstName())) {
			userDB.setKinFirstName(user.getKinFirstName());
		}
		
		if(Objects.nonNull(user.getKinLastName()) && !"".equalsIgnoreCase(user.getKinLastName())) {
			userDB.setKinLastName(user.getKinLastName());
		}
		
		if(Objects.nonNull(user.getKinEmail()) && !"".equalsIgnoreCase(user.getKinEmail())) {
			userDB.setKinEmail(user.getKinEmail());
		}
		
		if(Objects.nonNull(user.getKinPhoneNumber()) && !"".equalsIgnoreCase(user.getKinPhoneNumber())) {
			userDB.setKinPhoneNumber(user.getKinPhoneNumber());
		}
		
		if(Objects.nonNull(user.getKinNationality()) && !"".equalsIgnoreCase(user.getKinNationality())) {
			userDB.setKinNationality(user.getKinPhoneNumber());
		}

		if(Objects.nonNull(user.getGender()) && !"".equalsIgnoreCase(user.getGender())) {
			userDB.setGender(user.getGender());
		}

		if(Objects.nonNull(user.getKinGender()) && !"".equalsIgnoreCase(user.getKinGender())) {
			userDB.setKinGender(user.getKinGender());
		}
		
		return userRepository.save(userDB);
	}
	
	

//	@Override
//	public ResponseEntity<User> fetchCustomerId(String customerId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

// @Override
// @ResponseStatus(HttpStatus.OK)
// public User valateOTP(String oneTimePassword){
// 	// TODO Auto-generated method stub
// 	return userRepository.fetchOneTimePassword(oneTimePassword).get();
// }
	
@Override
@ResponseStatus(HttpStatus.OK)
public  User  fetchByOneTimePassword(String oneTimePassword){
	// TODO Auto-generated method stub
	 User mobileUser = new User();
	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	 String email = authentication.getName();
	 validateOneTimePassword(email, mobileUser);
	
	return userRepository.findByOneTimePassword(oneTimePassword).get();	
}

@Override
public User updateUserSignature(User user,HttpServletRequest request, String customerId, 
		MultipartFile[] extramultipartFile) throws IOException {
	// TODO Auto-generated method stub
	User userDB = userRepository.findByCustomerId(customerId).get();
	String SignaturePath = userDB.getSignaturepath();
	System.out.println( "Hello " + SignaturePath);
	String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
 			.replacePath(null)
 			.build()
			.toUriString();

			
			int count = 0;

			for(MultipartFile extramultipart : extramultipartFile ) {
				 			String fileName = StringUtils.cleanPath(extramultipart.getOriginalFilename());
							
				 			System.out.println(fileName);
							
				 			if(count == 0) user.setSingature(fileName);
				 			if(count == 1) user.setUtility_bill(fileName);
				 			if(count == 2) user.setVoter_card(fileName);
							
				 			count++;
							
						 }
		
	// if(Objects.nonNull(user.getSingature()) && !"".equalsIgnoreCase(user.getSingature())) {
	// 	userDB.setSingature(baseUrl);
	// }

	String uploadDir = "./kyc-doc/" + userDB.getCustomerId();
	for(MultipartFile extramultipart : extramultipartFile ) {
		String fileName = StringUtils.cleanPath(extramultipart.getOriginalFilename());
		FileUploadUtil.saveFile(uploadDir, extramultipart, fileName);
	}

	if(Objects.nonNull(user.getSingature()) && !"".equalsIgnoreCase(user.getSingature())) {
		for(MultipartFile extramultipart : extramultipartFile ) {
			String fileName = StringUtils.cleanPath(extramultipart.getOriginalFilename());
			userDB.setSingature(fileName);
		}
		
	}

 return userRepository.save(userDB);
}

@Override
public User storeSignature(User user, String customerId, MultipartFile extramultipartFile) throws IOException{
	// TODO Auto-generated method stub
	User userDB = userRepository.findByCustomerId(customerId).get();
	String fileName = StringUtils.cleanPath(extramultipartFile.getOriginalFilename());
	String uploadedFileName = UUID.randomUUID().toString() + "." + fileName;
	String uploadDir = "./kyc-doc/" + userDB.getCustomerId();
	//P//ath kycDoc = Paths.get("./kyc-doc/");
	// create a path for destination file
	//String kycUploadPath = kycDoc.toFile().getAbsolutePath();
	FileUploadUtil.saveFile(uploadDir, extramultipartFile, uploadedFileName);

				final String baseUrl =
                        ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

						final StringBuilder imageStringBuilder = new StringBuilder(baseUrl);
						imageStringBuilder.append("/fileUpload/files/");
						imageStringBuilder.append(uploadedFileName);

	return null;
	}

@Override
public Object fetchByVerificationCode(String verificationOtp) {
	// TODO Auto-generated method stub
	return userRepository.findByVerificationOtp(verificationOtp);
}

public void validateOneTimePassword(String email, User user){

	 final long OTP_VALID_DURATION = 5 * 60 * 1000;   // 5 minutes
	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	  email = authentication.getName();
	 User userDB = userRepository.findByEmail(email).get();
	long currentTimeInMillis = System.currentTimeMillis();
	long otpRequestedTimeInMillis = userDB.getOtpRequestedTime().getTime();
		System.out.print("hello " + otpRequestedTimeInMillis  + " + " + OTP_VALID_DURATION  + " < " + currentTimeInMillis);
	 if (otpRequestedTimeInMillis + OTP_VALID_DURATION < currentTimeInMillis) {
	 	// OTP expires
	 	user.setOneTimePassword("");
	 	userRepository.save(user);
		
	 }

}



}

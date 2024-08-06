package com.spearhead.nova.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.util.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
/* import org.slf4j.Logger;
import org.slf4j.LoggerFactory; */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.ObjectUtils;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.User;
import com.spearhead.nova.model.endpoint.SignOn;
import com.spearhead.nova.model.pojoClasses.DefaultMail;
import com.spearhead.nova.model.pojoClasses.SendMailTo;
import com.spearhead.nova.repository.UserRepository;
import com.spearhead.nova.security.JwtTokenProvider;
import com.spearhead.nova.service.impl.NotificationService;
import com.spearhead.nova.util.MethodUtils;

@Service
@Transactional
public class AuthService {

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	NotificationService NService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	JwtTokenProvider tokenProvider;

	@Autowired
	RestTemplate restTemplate;

	@Value("${spearhead.basedevurl}")
	private  String baseDevURL ; //
	// private static final Logger logger =
	// LoggerFactory.getLogger(AuthService.class);

	@Value("${spring.mail.username}")
    private String EMAIL_SENDER;

	public void generateOneTimePassword(String email, User user) throws UnsupportedEncodingException, MessagingException {

		Random random = new Random();
		// String OTP = RandomString.make(4);

		String OTP = String.format("%04d", random.nextInt(10000));

		BCryptPasswordEncoder otppasswordEncoder = new BCryptPasswordEncoder();
		String encodeOTP = otppasswordEncoder.encode(OTP);

		// Creating Numeric Field;
		// Random r = new Random();
		// End

		userRepository.sendNotificationByEmail(OTP, new java.util.Date(), email);
		System.out.println(" Email not Null and OTP is " + email + " Is" + OTP + " Encoded Otp " + encodeOTP);
		userRepository.sendNotificationByEmail(OTP, new java.util.Date(), email);
		sendOTPEmail(user, OTP, email);

	}

	public void generateEmailOneTimePassword(String email, User user) throws UnsupportedEncodingException, MessagingException {

		Random random = new Random();

		// String OTP = RandomString.make(4);
		String OTP = String.format("%04d", random.nextInt(10000));
		BCryptPasswordEncoder otppasswordEncoder = new BCryptPasswordEncoder();
		String encodeOTP = otppasswordEncoder.encode(OTP);

		userRepository.sendNotificationByEmail(OTP, new java.util.Date(), email);
		System.out.println(" Email not Null and OTP is " + email + " Is" + OTP + " Encoded Otp " + encodeOTP);
		userRepository.sendEmailNotificationByEmail(OTP, new java.util.Date(), email);
		sendOTPEmail(user, OTP, email);

	}

	private void sendOTPEmail(User user, String OTP, String email) throws UnsupportedEncodingException, MessagingException {
		//Comment out New Function connecting to symplus email api service
		// System.out.println("Hi i am here");
		// String path = baseDevURL + "/api/send";
		// ArrayList<SendMailTo> to = new ArrayList<>();
		// to.add(new SendMailTo(email));
		// DefaultMail dMail = new DefaultMail(
		// 		"Hello  Security reason you're required to use the following One-Time Password to login: <strong>" + OTP
		// 				+ "</strong>" + "<br />  YNote: This OTP will expire in 5 minutes: ",
		// 		"OTP Login Details", to);

		// MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		// headers.add("Content-Type", "application/json");
		// headers.add("Accept", "application/json");

		// HttpEntity<String> entity = new HttpEntity<>(dMail.toString(), headers);
		// System.out.println("HTTP ENTITY: " + entity + "Path is " + path);
		// URI uri;
		// try {
		// 	uri = new URI(path);
		// 	ResponseEntity<String> resultr = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
		// 	System.out.println(uri);
		// } catch (URISyntaxException e) {
		// 	// TODO Auto-generated catch block
		// 	e.printStackTrace();
		// }

		// System.out.println("Email Sent");

		// Restore Previous Function using symplus Mail service
		MimeMessage message = mailSender.createMimeMessage();
	 		MimeMessageHelper helper = new MimeMessageHelper(message);
	 		helper.setFrom(EMAIL_SENDER, "Your OTP Notification");
	 		helper.setTo(email);

			String subject = "Here is your one-Time password (OTP) ";

	 		String content = "<p> Hello  </p>"
	 							+ "<p> For Security reason you're required to use the following One-Time Password to login </p>"
	 							+ "<p><b>" + OTP + "</b></p>" + "<br>"
	 							+"<p> Note: This OTP will expire in 5 minutes"; 
	 		helper.setSubject(subject);
	 		helper.setText(content, true);

	 		mailSender.send(message);
 
	 		System.out.println("Email Sent");

	}

	public ResponseEntity<String> authenticate(SignOn user) throws UnsupportedEncodingException, MessagingException {

		JSONObject jsonObject = new JSONObject();
		User mobileUser = new User();
		try {
			System.out.println("hello24......");

			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			if (authentication.isAuthenticated()) {

			

				HttpHeaders responseHeaders = new HttpHeaders();
				String email = user.getUsername();


				generateOneTimePassword(email, mobileUser);

		

				SecurityContextHolder.getContext().setAuthentication(authentication);

				String jwt = tokenProvider.generateToken(authentication);

			

				User loggedInUser = userRepository.findByEmail(email).get();

		

				jsonObject.put("user_details", new JSONObject(loggedInUser.toString()));
				jsonObject.put("token", jwt);

				responseHeaders.set("x-auth-token", jwt);

				return new ResponseEntity<String>(MethodUtils.prepareResponseJSON(HttpStatus.OK, jsonObject.toString()),
						responseHeaders, HttpStatus.OK);

			} else {
				System.out.println("Failure ");
			}
		} catch (BadCredentialsException e) {
			return new ResponseEntity<String>(
					MethodUtils.prepareErrorJSON(HttpStatus.BAD_REQUEST, "Either email or password is incorrect"),
					HttpStatus.BAD_REQUEST);
		} catch (JSONException e) {
			try {
				jsonObject.put("exception", e.getMessage());
			} catch (JSONException e1) {
				e1.printStackTrace();
			}

			return new ResponseEntity<String>(
					MethodUtils.prepareErrorJSON(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return new ResponseEntity<String>(
				MethodUtils.prepareErrorJSON(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong"),
				HttpStatus.INTERNAL_SERVER_ERROR);

	}

	public ResponseEntity<StandardResponse> registerUser(User user) {

		StandardResponse sr = new StandardResponse();

		try {
			Boolean loggedInUser = userRepository.findByEmail(user.getEmail()).isPresent();

	
			if (!loggedInUser) {
				Random customerRand = new Random();
				// String OTP = RandomString.make(4);
				String soln = String.format("%04d", customerRand.nextInt(10000));
				String vOtp = String.format("%04d", customerRand.nextInt(10000));

				String password = passwordEncoder.encode(user.getPassword());
				String newId = user.getFirstName() + soln;
				System.out.println("Customer id" + newId);
				user.setPassword(password);
				user.setCustomerId(newId);
				user.setVerificationOtp(vOtp);
				// user.setCustomerId(newId);
				userRepository.save(user);
				// NService.sendRegistrationNotification(user);

				String path = baseDevURL + "/api/send";
				ArrayList<SendMailTo> to = new ArrayList<>();
				to.add(new SendMailTo(user.getEmail()));
				DefaultMail dMail = new DefaultMail(
						"Thank you for registering  with us and you Customer id is: <strong>" + newId
								+ "</strong>" + "<br />  Your Verification OTP is : " + vOtp,
						"You have succesffuly", to);

				MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
				headers.add("Content-Type", "application/json");
				headers.add("Accept", "application/json");

				HttpEntity<String> entity = new HttpEntity<>(dMail.toString(), headers);
				System.out.println("HTTP ENTITY: " + entity + "Path is " + path);
				URI uri = new URI(path);
				System.out.println(uri);

				ResponseEntity<String> resultr = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);

				sr.setStatus(true);
				sr.setMessage("User Registered");

				return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);

			} else {

				sr.setStatus(false);
				sr.setMessage("Email Already Exists");
				return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
			}

		} catch (Exception ex) {

			sr.setStatus(false);
			sr.setMessage(ex.getMessage());
		}

		return new ResponseEntity<StandardResponse>(sr, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	public ResponseEntity<StandardResponse> forgetpassword(@RequestParam("email") String useremail)
			throws UnsupportedEncodingException, MessagingException {
		Object datas = userRepository.findByEmail(useremail).get();
		User mobileUser = new User();
		StandardResponse sr = new StandardResponse();

		if (ObjectUtils.isNotEmpty(datas)) {
			System.out.println("Hello");
			// String OTP = RandomString.make(4);
			generateEmailOneTimePassword(useremail, mobileUser);
			sr.setMessage("Email Succesfully Sent");
			sr.setStatus(true);
			sr.setStatuscode("200");
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		} else {
			sr.setMessage("Inavlid Email");
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		// return null;
	}

	public ResponseEntity<StandardResponse> ResendOtp(@RequestParam("email") String useremail)
			throws UnsupportedEncodingException, MessagingException {
		Object datas = userRepository.findByEmail(useremail).get();
		User mobileUser = new User();
		StandardResponse sr = new StandardResponse();

		if (ObjectUtils.isNotEmpty(datas)) {
			System.out.println("Hello " + useremail);
			// String OTP = RandomString.make(4);
			generateOneTimePassword(useremail, mobileUser);
			// generateEmailOneTimePassword(useremail, mobileUser);
			sr.setMessage("Email Succesfully Sent");
			sr.setStatus(true);
			sr.setStatuscode("200");
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		} else {
			sr.setMessage("Inavlid Email");
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		// return null;
	}

	public ResponseEntity<StandardResponse> resetpassword(String password, String email) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodeOTP = passwordEncoder.encode(password);

		StandardResponse sr = new StandardResponse();

		try {
			sr.setMessage("Password Reset Succesfull");
			sr.setStatus(true);
			sr.setStatuscode("200");
			Object datas = userRepository.updatePassword(encodeOTP, email);

			if (ObjectUtils.isNotEmpty(datas)) {
				String OTP = RandomString.make(4);
				userRepository.sendEmailNotificationByEmail(OTP, new java.util.Date(), email);
				return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
			} else {
				sr.setMessage("Password Reset Unsuccesfull");
				sr.setStatus(false);
				return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);

			}

		} catch (Exception e) {
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		// return null;
	}

	public User fetchIsVerifiedStatus(String verificationOtp, User user) {

		User userDB = userRepository.findByVerificationOtp(verificationOtp).get();

		userDB.setIsVerified(true);
		return userRepository.save(userDB);

	}

	public ResponseEntity<StandardResponse> verifyCode(@RequestParam("verificationOtp") String verificationOtp) {

		Object data = userRepository.findByVerificationOtp(verificationOtp).get();

		User mobileUser = new User();

		StandardResponse sr = new StandardResponse();
		System.out.println("Hello ... 2");

		try {
			sr.setMessage("Password Reset Succesfull");
			sr.setStatus(true);
			sr.setStatuscode("200");

			System.out.println("Hello ... 3");

			if (ObjectUtils.isNotEmpty(data)) {
				
				Object verifiedStatus = fetchIsVerifiedStatus(verificationOtp, mobileUser);


				System.out.println("Hello ... 4 " + verificationOtp);

				sr.setData(verifiedStatus);
				sr.setMessage("Otp Validate");
				sr.setStatus(true);
				sr.setStatuscode("200");

				return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
			} else {
				sr.setMessage("Could Not verify Verification Code");
				sr.setStatus(false);
				return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);

			}

		} catch (Exception e) {
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		// return null;
	}

}
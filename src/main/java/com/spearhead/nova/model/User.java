package com.spearhead.nova.model;


import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.checkerframework.checker.units.qual.Length;


@Entity
@Table(name = "users",schema="dbo" ,uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User extends DateAudit{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
	private Long userId;
    
    private String username;
    
    private String firstName;


	// adding kyc update 12-2022-7:35pm
	private String singature;
	private String utility_bill;
	private String voter_card;
	public String getSingature() {
		return singature;
	}

	public void setSingature(String singature) {
		this.singature = singature;
	}

	public String getUtility_bill() {
		return utility_bill;
	}

	public void setUtility_bill(String utility_bill) {
		this.utility_bill = utility_bill;
	}

	public String getVoter_card() {
		return voter_card;
	}

	public void setVoter_card(String voter_card) {
		this.voter_card = voter_card;
	}

	@Transient
	public String getSignaturepath(){
		if(singature == null || customerId == null) return null;

		System.out.println("I amd here too " + "/kyc-doc/" + customerId + "/" + singature);
		return "/kyc-doc/" + customerId + "/" + singature;
	}

	// End of Kyc Update


	private String lastName;
	
    
    private String email;
    
    private String password;
    
    private String phoneNumber;

	private String customerId;
	
	private String streetNumber;
	private String streetName;
	private String city;
	private String country;
	private String nationality;
	private String bvn;
	
	
	
    private String kinFirstName;
	private String kinLastName;   
    private String kinEmail;
    private String kinPhoneNumber;
    private String kinNationality;
    private String kinAddress;

    private String isCompleted;

	private String oneTimePassword;
    private Date otpRequestedTime;
	public String emailOneTimePassword;
	private Date emailRequestedTime;
	private String gender;
	private String kinGender;
	private String verificationOtp;
	@Column(columnDefinition = "boolean default 0")
	private  boolean isVerified;
	

	
	public boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getKinGender() {
		return kinGender;
	}

	public void setKinGender(String kinGender) {
		this.kinGender = kinGender;
	}

	public Date getEmailRequestedTime() {
		return emailRequestedTime;
	}

	public void setEmailRequestedTime(Date emailRequestedTime) {
		this.emailRequestedTime = emailRequestedTime;
	}

	public String getEmailOneTimePassword() {
		return emailOneTimePassword;
	}

	public void setEmailOneTimePassword(String emailOneTimePassword) {
		this.emailOneTimePassword = emailOneTimePassword;
	}

	public String getOneTimePassword() {
		return oneTimePassword;
		}
		
		public void setOneTimePassword(String oneTimePassword) {
		this.oneTimePassword = oneTimePassword;
		}
		
		
	

	public Date getOtpRequestedTime() {
			return otpRequestedTime;
		}

		public void setOtpRequestedTime(Date otpRequestedTime) {
			this.otpRequestedTime = otpRequestedTime;
		}

	public String getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(String isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String getKinFirstName() {
		return kinFirstName;
	}

	public void setKinFirstName(String kinFirstName) {
		this.kinFirstName = kinFirstName;
	}

	public String getKinLastName() {
		return kinLastName;
	}

	public void setKinLastName(String kinLastName) {
		this.kinLastName = kinLastName;
	}

	public String getKinEmail() {
		return kinEmail;
	}

	public void setKinEmail(String kinEmail) {
		this.kinEmail = kinEmail;
	}

	public String getKinPhoneNumber() {
		return kinPhoneNumber;
	}

	public void setKinPhoneNumber(String kinPhoneNumber) {
		this.kinPhoneNumber = kinPhoneNumber;
	}

	public String getKinNationality() {
		return kinNationality;
	}

	public void setKinNationality(String kinNationality) {
		this.kinNationality = kinNationality;
	}

	public String getKinAddress() {
		return kinAddress;
	}

	public void setKinAddress(String kinAddress) {
		this.kinAddress = kinAddress;
	}

	public String getBvn() {
		return bvn;
	}

	public void setBvn(String bvn) {
		this.bvn = bvn;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}


	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}


   






	public String getVerificationOtp() {
		return verificationOtp;
	}

	public void setVerificationOtp(String verificationOtp) {
		this.verificationOtp = verificationOtp;
	}

	public User() {
		super();
	}	


	



	public User(Long userId, String username, String firstName, String lastName, String email, String password,
			String phoneNumber, String customerId, String streetNumber, String streetName, String city, String country,
			String nationality, String bvn, String kinFirstName, String kinLastName, String kinEmail,
			String kinPhoneNumber, String kinNationality, String kinAddress, String isCompleted, String oneTimePassword,
			Date otpRequestedTime, String emailOneTimePassword, Date emailRequestedTime, String gender, String kinGender, String singature, String utility_bill, String voter_card, String verificationOtp, boolean isVerified) {
		super();
		this.userId = userId;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.customerId = customerId;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.country = country;
		this.nationality = nationality;
		this.bvn = bvn;
		this.kinFirstName = kinFirstName;
		this.kinLastName = kinLastName;
		this.kinEmail = kinEmail;
		this.kinPhoneNumber = kinPhoneNumber;
		this.kinNationality = kinNationality;
		this.kinAddress = kinAddress;
		this.isCompleted = isCompleted;
		this.oneTimePassword = oneTimePassword;
		this.otpRequestedTime = otpRequestedTime;
		this.emailOneTimePassword = emailOneTimePassword;
		this.emailRequestedTime = emailRequestedTime;
		this.gender = gender;
		this.kinGender = kinGender;

		this.singature = singature;
		this.utility_bill = utility_bill;
		this.voter_card   = voter_card;

		this.verificationOtp   = verificationOtp;
		this.isVerified   = isVerified;
		

	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	    
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customercode) {
		this.customerId = customercode;
	}
	

		// public boolean isOTPrequired(){
		// 		if(this.oneTimePassword == null){
		// 			return false;
		// 		}
		// 		long otpRequestedTimeInMillis   = this.otpRequestedTime.getTime();

		// 		if(otpRequestedTimeInMillis + OTP_VALID_DURATION <  System.currentTimeMillis()){
		// 			return false;
		// 		}
		// 		return true;
		// }

		// private static final long OTP_VALID_DURATION = 5 * 60 * 1000;
	

	@Override
	public String toString() {
		//return "{\"userId\": " + userId + ",\"username\":\""+username+"\",\"name\":\""+ firstName+"\",\"email\":\""+email+"\"}";
		return "{\"userId\": " + userId + ",\"username\":\""+username+"\",\"name\":\""+ firstName+"\",\"userverified\":\""+ isVerified+"\",\"email\":\""+email+"\"}";
	}
		    
}

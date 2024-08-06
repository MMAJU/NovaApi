package com.spearhead.nova.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class NextOfKin extends DateAudit{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 100
   		)
	
	private Long kinId;
    private String kinFirstName;
	private String kinLastName;   
    private String kinEmail;
    private String kinPhoneNumber;
    private String kinNationality;
    private String kinAddress;
    
    @OneToOne 
    @JoinColumn(
    		name = "customer_id",
    		referencedColumnName = "customerId"
    		)
    private User user;
	public Long getKinId() {
		return kinId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setKinId(Long kinId) {
		this.kinId = kinId;
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
	public NextOfKin(Long kinId, String kinFirstName, String kinLastName, String kinEmail, String kinPhoneNumber,
			String kinNationality, String kinAddress, User user) {
		super();
		this.kinId = kinId;
		this.kinFirstName = kinFirstName;
		this.kinLastName = kinLastName;
		this.kinEmail = kinEmail;
		this.kinPhoneNumber = kinPhoneNumber;
		this.kinNationality = kinNationality;
		this.kinAddress = kinAddress;
	}
    
	public NextOfKin() {
		super();
	}	

}

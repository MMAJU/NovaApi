package com.spearhead.nova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Kyc extends DateAudit {
	
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
	
	private Long kycId; 

	private String customerId;
	
	private String utilityBill;

	private String singature;
	
	private String  voterCard;



	public Long getKycId() {
		return kycId;
	}

	public void setKycId(Long kycId) {
		this.kycId = kycId;
	}
	
	public Kyc() {
		super();
	}	

	@Override
	public String toString() {
		return "Kyc [kycId=" + kycId + ", customerId=" + customerId + ", utilityBill=" + utilityBill + ", singature="
				+ singature + ", voterCard=" + voterCard + "]";
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getUtilityBill() {
		return utilityBill;
	}

	public void setUtilityBill(String utilityBill) {
		this.utilityBill = utilityBill;
	}

	public String getSingature() {
		return singature;
	}

	public void setSingature(String singature) {
		this.singature = singature;
	}

	public String getVoterCard() {
		return voterCard;
	}

	public void setVoterCard(String voterCard) {
		this.voterCard = voterCard;
	}

	public Kyc(Long kycId, String customerId, String utilityBill, String singature, String voterCard) {
		super();
		this.kycId = kycId;
		this.customerId = customerId;
		this.utilityBill = utilityBill;
		this.singature = singature;
		this.voterCard = voterCard;
		
	}
	
	
	
}

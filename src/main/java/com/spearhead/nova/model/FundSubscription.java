package com.spearhead.nova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class FundSubscription extends DateAudit {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
	
	private Long fundSubscriptionId; 
	private String fund;
	private String account;
	private String date;
	private float price;
	private int quantity;
	private String reference;
	
	
	
	
	public Long getFundSubscriptionId() {
		return fundSubscriptionId;
	}
	public void setFundSubscriptionId(Long fundSubscriptionId) {
		this.fundSubscriptionId = fundSubscriptionId;
	}
	public String getFund() {
		return fund;
	}
	public void setFund(String fund) {
		this.fund = fund;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public FundSubscription(Long fundSubscriptionId, String fund, String account, String date, float price,
			int quantity, String reference) {
		super();
		this.fundSubscriptionId = fundSubscriptionId;
		this.fund = fund;
		this.account = account;
		this.date = date;
		this.price = price;
		this.quantity = quantity;
		this.reference = reference;
	}
	
	
	@Override
	public String toString() {
		return "FundSubscription [fundSubscriptionId=" + fundSubscriptionId + ", fund=" + fund + ", account=" + account
				+ ", date=" + date + ", price=" + price + ", quantity=" + quantity + ", reference=" + reference + "]";
	}
	public FundSubscription() {
		super();
	}	
	
	

}

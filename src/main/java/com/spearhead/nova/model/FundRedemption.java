package com.spearhead.nova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class FundRedemption extends DateAudit {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
	
	private Long fundRedemptionId; 
	private String fund;
	private String account;
	private String fundDate;
	private float price;
	private int quantity;
	private String reference;
	
	
	public String getFund() {
		return fund;
	}
	public void setFund(String fund) {
		this.fund = fund;
	}
	public Long getFundRedemptionId() {
		return fundRedemptionId;
	}
	public void setFundRedemptionId(Long fundRedemptionId) {
		this.fundRedemptionId = fundRedemptionId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getFundDate() {
		return fundDate;
	}
	public void setFundDate(String fundDate) {
		this.fundDate = fundDate;
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
	
	@Override
	public String toString() {
		return "FundRedemption [fundRedemptionId=" + fundRedemptionId + ", fund=" + fund + ", account=" + account
				+ ", fundDate=" + fundDate + ", price=" + price + ", quantity=" + quantity + ", reference=" + reference
				+ "]";
	}
	
	
	public FundRedemption(Long fundRedemptionId, String fund, String account, String fundDate, float price,
			int quantity, String reference) {
		super();
		this.fundRedemptionId = fundRedemptionId;
		this.fund = fund;
		this.account = account;
		this.fundDate = fundDate;
		this.price = price;
		this.quantity = quantity;
		this.reference = reference;
	}
	public FundRedemption() {
		super();
	}
	
}

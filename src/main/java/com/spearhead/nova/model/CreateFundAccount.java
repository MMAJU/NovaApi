package com.spearhead.nova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class CreateFundAccount extends DateAudit {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
	
	private Long fundAccountId;
	private String customer;
	private String fund;
	private String account;
	private String accountName;
	private String registrar;
	private String externalRef;
	private String reInvest;
	private int reInvestpct;
	
	
	
	
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Long getFundAccountId() {
		return fundAccountId;
	}
	public void setFundAccountId(Long fundAccountId) {
		this.fundAccountId = fundAccountId;
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
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getRegistrar() {
		return registrar;
	}
	public void setRegistrar(String registrar) {
		this.registrar = registrar;
	}
	public String getExternalRef() {
		return externalRef;
	}
	public void setExternalRef(String externalRef) {
		this.externalRef = externalRef;
	}
	public String getReInvest() {
		return reInvest;
	}
	public void setReInvest(String reInvest) {
		this.reInvest = reInvest;
	}
	public int getReInvestpct() {
		return reInvestpct;
	}
	public void setReInvestpct(int reInvestpct) {
		this.reInvestpct = reInvestpct;
	}
	
	public CreateFundAccount(Long fundAccountId, String customer, String fund, String account, String accountName,
			String registrar, String externalRef, String reInvest, int reInvestpct) {
		super();
		this.fundAccountId = fundAccountId;
		this.customer = customer;
		this.fund = fund;
		this.account = account;
		this.accountName = accountName;
		this.registrar = registrar;
		this.externalRef = externalRef;
		this.reInvest = reInvest;
		this.reInvestpct = reInvestpct;
	}

	
	@Override
	public String toString() {
		return "CreateFundAccount [fundAccountId=" + fundAccountId + ", customer=" + customer + ", fund=" + fund
				+ ", account=" + account + ", accountName=" + accountName + ", registrar=" + registrar
				+ ", externalRef=" + externalRef + ", reInvest=" + reInvest + ", reInvestpct=" + reInvestpct + "]";
	}
	public CreateFundAccount() {
		super();
	}

}

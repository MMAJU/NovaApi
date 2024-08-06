package com.spearhead.nova.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class FundPortfolio extends DateAudit {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
	private Long fundPortfolioId;
	private String accountId;
	private String customerId; 
	private String accountName; 
	private String productName; 
	private Float principal;
	private Float rate;
	private Float tenor;
	private String effectiveDate;
	private String maturityDate;
	private Float accruedInterest;
	private String currencyId;
	
	
	
	
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Long getFundPortfolioId() {
		return fundPortfolioId;
	}
	public void setFundPortfolioId(Long fundPortfolioId) {
		this.fundPortfolioId = fundPortfolioId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Float getPrincipal() {
		return principal;
	}
	public void setPrincipal(Float principal) {
		this.principal = principal;
	}
	public Float getRate() {
		return rate;
	}
	public void setRate(Float rate) {
		this.rate = rate;
	}
	public Float getTenor() {
		return tenor;
	}
	public void setTenor(Float tenor) {
		this.tenor = tenor;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}
	public Float getAccruedInterest() {
		return accruedInterest;
	}
	public void setAccruedInterest(Float accruedInterest) {
		this.accruedInterest = accruedInterest;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	
	
	
	
	public FundPortfolio(Long fundPortfolioId, String accountId, String productName, Float principal, Float rate,
			Float tenor, String effectiveDate, String maturityDate, Float accruedInterest, String currencyId, String accountName, String customerId) {
		super();
		this.fundPortfolioId = fundPortfolioId;
		this.accountId = accountId;
		this.productName = productName;
		this.principal = principal;
		this.rate = rate;
		this.tenor = tenor;
		this.effectiveDate = effectiveDate;
		this.maturityDate = maturityDate;
		this.accruedInterest = accruedInterest;
		this.currencyId = currencyId;
		this.accountName = accountName;
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "FundPortfolio [accountId=" + accountId + ", accountName=" + accountName + ", accruedInterest="
				+ accruedInterest + ", currencyId=" + currencyId + ", customerId=" + customerId + ", effectiveDate="
				+ effectiveDate + ", fundPortfolioId=" + fundPortfolioId + ", maturityDate=" + maturityDate
				+ ", principal=" + principal + ", productName=" + productName + ", rate=" + rate + ", tenor=" + tenor
				+ "]";
	}
	
	public FundPortfolio() {
		super();
	}	

	
	
	
}

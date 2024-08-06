package com.spearhead.nova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class FixedDeposit extends DateAudit {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
	
	private Long fixedDepositId;
	private String fundId;
	private String fundDescription;
	private String productDescription;
	private String customerId;
	private String customerName;
	private String placementId;
	private String accountType;
	private String revaluationSequence;
	private String  currencyId;
	private String curencyDescription;
	private String investmentAmount;
	private String effectiveDate;
	private String tenorDays;
	private String maturityDate;
	private String maturityMandate;
	private String interestRate;
	private String currentBalanceAmount;
	private String expectedGrossInterestAmount;
	private String expectedNetInterestAmount;
	private String accruedInterestAmount;
	private String lastAccruedDate;
	private String totalInterestPaidAmount;
	private String totalTaxPaidAmount;
	private String Status;
	private String dateClosed;
	private String isClosed;
	public Long getFixedDepositId() {
		return fixedDepositId;
	}
	public void setFixedDepositId(Long fixedDepositId) {
		this.fixedDepositId = fixedDepositId;
	}
	public String getFundId() {
		return fundId;
	}
	public void setFundId(String fundId) {
		this.fundId = fundId;
	}
	public String getFundDescription() {
		return fundDescription;
	}
	public void setFundDescription(String fundDescription) {
		this.fundDescription = fundDescription;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPlacementId() {
		return placementId;
	}
	public void setPlacementId(String placementId) {
		this.placementId = placementId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getRevaluationSequence() {
		return revaluationSequence;
	}
	public void setRevaluationSequence(String revaluationSequence) {
		this.revaluationSequence = revaluationSequence;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public String getCurencyDescription() {
		return curencyDescription;
	}
	public void setCurencyDescription(String curencyDescription) {
		this.curencyDescription = curencyDescription;
	}
	public String getInvestmentAmount() {
		return investmentAmount;
	}
	public void setInvestmentAmount(String investmentAmount) {
		this.investmentAmount = investmentAmount;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getTenorDays() {
		return tenorDays;
	}
	public void setTenorDays(String tenorDays) {
		this.tenorDays = tenorDays;
	}
	public String getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}
	public String getMaturityMandate() {
		return maturityMandate;
	}
	public void setMaturityMandate(String maturityMandate) {
		this.maturityMandate = maturityMandate;
	}
	public String getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	public String getCurrentBalanceAmount() {
		return currentBalanceAmount;
	}
	public void setCurrentBalanceAmount(String currentBalanceAmount) {
		this.currentBalanceAmount = currentBalanceAmount;
	}
	public String getExpectedGrossInterestAmount() {
		return expectedGrossInterestAmount;
	}
	public void setExpectedGrossInterestAmount(String expectedGrossInterestAmount) {
		this.expectedGrossInterestAmount = expectedGrossInterestAmount;
	}
	public String getExpectedNetInterestAmount() {
		return expectedNetInterestAmount;
	}
	public void setExpectedNetInterestAmount(String expectedNetInterestAmount) {
		this.expectedNetInterestAmount = expectedNetInterestAmount;
	}
	public String getAccruedInterestAmount() {
		return accruedInterestAmount;
	}
	public void setAccruedInterestAmount(String accruedInterestAmount) {
		this.accruedInterestAmount = accruedInterestAmount;
	}
	public String getLastAccruedDate() {
		return lastAccruedDate;
	}
	public void setLastAccruedDate(String lastAccruedDate) {
		this.lastAccruedDate = lastAccruedDate;
	}
	public String getTotalInterestPaidAmount() {
		return totalInterestPaidAmount;
	}
	public void setTotalInterestPaidAmount(String totalInterestPaidAmount) {
		this.totalInterestPaidAmount = totalInterestPaidAmount;
	}
	public String getTotalTaxPaidAmount() {
		return totalTaxPaidAmount;
	}
	public void setTotalTaxPaidAmount(String totalTaxPaidAmount) {
		this.totalTaxPaidAmount = totalTaxPaidAmount;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getDateClosed() {
		return dateClosed;
	}
	public void setDateClosed(String dateClosed) {
		this.dateClosed = dateClosed;
	}
	public String getIsClosed() {
		return isClosed;
	}
	public void setIsClosed(String isClosed) {
		this.isClosed = isClosed;
	}
	public FixedDeposit(Long fixedDepositId, String fundId, String fundDescription, String productDescription,
			String customerId, String customerName, String placementId, String accountType, String revaluationSequence,
			String currencyId, String curencyDescription, String investmentAmount, String effectiveDate,
			String tenorDays, String maturityDate, String maturityMandate, String interestRate,
			String currentBalanceAmount, String expectedGrossInterestAmount, String expectedNetInterestAmount,
			String accruedInterestAmount, String lastAccruedDate, String totalInterestPaidAmount,
			String totalTaxPaidAmount, String status, String dateClosed, String isClosed) {
		super();
		this.fixedDepositId = fixedDepositId;
		this.fundId = fundId;
		this.fundDescription = fundDescription;
		this.productDescription = productDescription;
		this.customerId = customerId;
		this.customerName = customerName;
		this.placementId = placementId;
		this.accountType = accountType;
		this.revaluationSequence = revaluationSequence;
		this.currencyId = currencyId;
		this.curencyDescription = curencyDescription;
		this.investmentAmount = investmentAmount;
		this.effectiveDate = effectiveDate;
		this.tenorDays = tenorDays;
		this.maturityDate = maturityDate;
		this.maturityMandate = maturityMandate;
		this.interestRate = interestRate;
		this.currentBalanceAmount = currentBalanceAmount;
		this.expectedGrossInterestAmount = expectedGrossInterestAmount;
		this.expectedNetInterestAmount = expectedNetInterestAmount;
		this.accruedInterestAmount = accruedInterestAmount;
		this.lastAccruedDate = lastAccruedDate;
		this.totalInterestPaidAmount = totalInterestPaidAmount;
		this.totalTaxPaidAmount = totalTaxPaidAmount;
		Status = status;
		this.dateClosed = dateClosed;
		this.isClosed = isClosed;
	}
	@Override
	public String toString() {
		return "FixedDeposit [fixedDepositId=" + fixedDepositId + ", fundId=" + fundId + ", fundDescription="
				+ fundDescription + ", productDescription=" + productDescription + ", customerId=" + customerId
				+ ", customerName=" + customerName + ", placementId=" + placementId + ", accountType=" + accountType
				+ ", revaluationSequence=" + revaluationSequence + ", currencyId=" + currencyId
				+ ", curencyDescription=" + curencyDescription + ", investmentAmount=" + investmentAmount
				+ ", effectiveDate=" + effectiveDate + ", tenorDays=" + tenorDays + ", maturityDate=" + maturityDate
				+ ", maturityMandate=" + maturityMandate + ", interestRate=" + interestRate + ", currentBalanceAmount="
				+ currentBalanceAmount + ", expectedGrossInterestAmount=" + expectedGrossInterestAmount
				+ ", expectedNetInterestAmount=" + expectedNetInterestAmount + ", accruedInterestAmount="
				+ accruedInterestAmount + ", lastAccruedDate=" + lastAccruedDate + ", totalInterestPaidAmount="
				+ totalInterestPaidAmount + ", totalTaxPaidAmount=" + totalTaxPaidAmount + ", Status=" + Status
				+ ", dateClosed=" + dateClosed + ", isClosed=" + isClosed + "]";
	}
	
	
	
	public FixedDeposit() {
		super();
	}	

}

package com.spearhead.nova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class CashAccountGet  extends DateAudit{

    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
    private Long cashAccountId;
    private String accountNo;
	private String customerId;
	private String accountName;
	private String availableBalance;

    private String currentBalance;
    private String accruedCreditInterest;
	private String accruedDebitInterest;
	private String currencyId;
	private String currencyName;

    private String productId;
	private String productName;
	private String dateOpened;

    private String lastDebitDate;
	private String lastCreditDate;
    public Long getCashAccountId() {
        return cashAccountId;
    }
    public void setCashAccountId(Long cashAccountId) {
        this.cashAccountId = cashAccountId;
    }
    public String getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
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
    public String getAvailableBalance() {
        return availableBalance;
    }
    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }
    public String getCurrentBalance() {
        return currentBalance;
    }
    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
    }
    public String getAccruedCreditInterest() {
        return accruedCreditInterest;
    }
    public void setAccruedCreditInterest(String accruedCreditInterest) {
        this.accruedCreditInterest = accruedCreditInterest;
    }
    public String getAccruedDebitInterest() {
        return accruedDebitInterest;
    }
    public void setAccruedDebitInterest(String accruedDebitInterest) {
        this.accruedDebitInterest = accruedDebitInterest;
    }
    public String getCurrencyId() {
        return currencyId;
    }
    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }
    public String getCurrencyName() {
        return currencyName;
    }
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getDateOpened() {
        return dateOpened;
    }
    public void setDateOpened(String dateOpened) {
        this.dateOpened = dateOpened;
    }
    public String getLastDebitDate() {
        return lastDebitDate;
    }
    public void setLastDebitDate(String lastDebitDate) {
        this.lastDebitDate = lastDebitDate;
    }
    public String getLastCreditDate() {
        return lastCreditDate;
    }
    public void setLastCreditDate(String lastCreditDate) {
        this.lastCreditDate = lastCreditDate;
    }

    

    public CashAccountGet(Long cashAccountId, String accountNo, String customerId, String accountName,
            String availableBalance, String currentBalance, String accruedCreditInterest, String accruedDebitInterest,
            String currencyId, String currencyName, String productId, String productName, String dateOpened,
            String lastDebitDate, String lastCreditDate) {
        this.cashAccountId = cashAccountId;
        this.accountNo = accountNo;
        this.customerId = customerId;
        this.accountName = accountName;
        this.availableBalance = availableBalance;
        this.currentBalance = currentBalance;
        this.accruedCreditInterest = accruedCreditInterest;
        this.accruedDebitInterest = accruedDebitInterest;
        this.currencyId = currencyId;
        this.currencyName = currencyName;
        this.productId = productId;
        this.productName = productName;
        this.dateOpened = dateOpened;
        this.lastDebitDate = lastDebitDate;
        this.lastCreditDate = lastCreditDate;
    }


    

    @Override
    public String toString() {
        return "CashAccountGet [accountName=" + accountName + ", accountNo=" + accountNo + ", accruedCreditInterest="
                + accruedCreditInterest + ", accruedDebitInterest=" + accruedDebitInterest + ", availableBalance="
                + availableBalance + ", cashAccountId=" + cashAccountId + ", currencyId=" + currencyId
                + ", currencyName=" + currencyName + ", currentBalance=" + currentBalance + ", customerId=" + customerId
                + ", dateOpened=" + dateOpened + ", lastCreditDate=" + lastCreditDate + ", lastDebitDate="
                + lastDebitDate + ", productId=" + productId + ", productName=" + productName + "]";
    }
    public CashAccountGet() {
        super();
    }

    
    
}

package com.spearhead.nova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class CashDeposit extends DateAudit {
    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)

    private Long cashDepositId;
    private String customer;
    private String account;
    private String date;
    private String amount;
    private String description;
    private String reference;
    private String contra;
    public Long getCashDepositId() {
        return cashDepositId;
    }
    public void setCashDepositId(Long cashDepositId) {
        this.cashDepositId = cashDepositId;
    }
    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
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
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    public String getContra() {
        return contra;
    }
    public void setContra(String contra) {
        this.contra = contra;
    }
    public CashDeposit(Long cashDepositId, String customer, String account, String date, String amount,
            String description, String reference, String contra) {
        this.cashDepositId = cashDepositId;
        this.customer = customer;
        this.account = account;
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.reference = reference;
        this.contra = contra;
    }
    @Override
    public String toString() {
        return "CashDeposit [account=" + account + ", amount=" + amount + ", cashDepositId=" + cashDepositId
                + ", contra=" + contra + ", customer=" + customer + ", date=" + date + ", description=" + description
                + ", reference=" + reference + "]";
    }
    public CashDeposit() {
        super();
    }




}

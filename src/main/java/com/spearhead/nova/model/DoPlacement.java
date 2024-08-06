package com.spearhead.nova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class DoPlacement extends DateAudit {

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
           private Long doPlacementId;
           private String product;
	private String customer;
	private String account;
	private String tenor;
	private String rate;
	private String amount;
	private String taxable;
	private String rollover;
	private String  reference;
    public Long getDoPlacementId() {
        return doPlacementId;
    }
    public void setDoPlacementId(Long doPlacementId) {
        this.doPlacementId = doPlacementId;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
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
    public String getTenor() {
        return tenor;
    }
    public void setTenor(String tenor) {
        this.tenor = tenor;
    }
    public String getRate() {
        return rate;
    }
    public void setRate(String rate) {
        this.rate = rate;
    }
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getTaxable() {
        return taxable;
    }
    public void setTaxable(String taxable) {
        this.taxable = taxable;
    }
    public String getRollover() {
        return rollover;
    }
    public void setRollover(String rollover) {
        this.rollover = rollover;
    }
    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    public DoPlacement(Long doPlacementId, String product, String customer, String account, String tenor, String rate,
            String amount, String taxable, String rollover, String reference) {
        this.doPlacementId = doPlacementId;
        this.product = product;
        this.customer = customer;
        this.account = account;
        this.tenor = tenor;
        this.rate = rate;
        this.amount = amount;
        this.taxable = taxable;
        this.rollover = rollover;
        this.reference = reference;
    }
    @Override
    public String toString() {
        return "DoPlacement [account=" + account + ", amount=" + amount + ", customer=" + customer + ", doPlacementId="
                + doPlacementId + ", product=" + product + ", rate=" + rate + ", reference=" + reference + ", rollover="
                + rollover + ", taxable=" + taxable + ", tenor=" + tenor + "]";
    }

    
    public DoPlacement() {
		super();
	}

    
}

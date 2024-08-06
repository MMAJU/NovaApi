package com.spearhead.nova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class CashAccount extends DateAudit{

    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
    
    private Long cashAccoundId;
    private String customerId;
    private String name;
    private String description;
    private String manadate;
    private String officer;
    private String reference;
    public Long getCashAccoundId() {
        return cashAccoundId;
    }
    public void setCashAccoundId(Long cashAccoundId) {
        this.cashAccoundId = cashAccoundId;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getManadate() {
        return manadate;
    }
    public void setManadate(String manadate) {
        this.manadate = manadate;
    }
    public String getOfficer() {
        return officer;
    }
    public void setOfficer(String officer) {
        this.officer = officer;
    }
    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    @Override
    public String toString() {
        return "CashAccount [cashAccoundId=" + cashAccoundId + ", customerId=" + customerId + ", description="
                + description + ", manadate=" + manadate + ", name=" + name + ", officer=" + officer + ", reference="
                + reference + "]";
    }
    public CashAccount() {
		super();
	}	



    





    

    
}

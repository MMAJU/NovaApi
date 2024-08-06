package com.spearhead.nova.model.pojoClasses;

public class Create {

    private String customer;
    private String plan;

    private String description;
    private String manadate;
    private String officer;
    private String reference;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
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

    public Create() {
    }

    public Create(String customer, String plan, String description, String manadate, String officer,
            String reference) {
        this.customer = customer;
        this.plan = plan;

        this.description = description;
        this.manadate = manadate;
        this.officer = officer;
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "{\"customer\":\"" + customer + "\",\"plan\":\"" + plan
                + "\",\"description\":\"" + description + "\",\"manadate\":\""
                + manadate + "\", \"officer\":\"" + officer + "\", \"reference\":\""
                + reference + "\"}";

    }

}

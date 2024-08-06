package com.spearhead.nova.model.pojoClasses;

public class DoCash {

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

    public DoCash(Long cashAccoundId, String customerId, String name, String description, String manadate,
            String officer, String reference) {
        this.cashAccoundId = cashAccoundId;
        this.customerId = customerId;
        this.name = name;
        this.description = description;
        this.manadate = manadate;
        this.officer = officer;
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "{\"cashAccoundId\":\"" + cashAccoundId + "\",\"customerId\":\"" + customerId
                + "\",\"description\":\"" + description + "\",\"manadate\":\""
                + manadate + "\",\"name\":\"" + name + "\", \"officer\":\"" + officer + "\", \"reference\":\""
                + reference + "\"}";

    }

}

package com.spearhead.nova.model.pojoClasses;

public class Tbillliq {
    private String customer;
    private String order;
    private String effective;
    private String debitaccount;
    private String creditaccount;
    private String remarks;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getEffective() {
        return effective;
    }

    public void setEffective(String effective) {
        this.effective = effective;
    }

    public String getDebitaccount() {
        return debitaccount;
    }

    public void setDebitaccount(String debitaccount) {
        this.debitaccount = debitaccount;
    }

    public String getCreditaccount() {
        return creditaccount;
    }

    public void setCreditaccount(String creditaccount) {
        this.creditaccount = creditaccount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Tbillliq(String customer, String order, String effective, String debitaccount, String creditaccount,
            String remarks) {
        this.customer = customer;
        this.order = order;
        this.effective = effective;
        this.debitaccount = debitaccount;
        this.creditaccount = creditaccount;
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "{\"creditaccount\":\"" + creditaccount + "\",\"customer\":\"" + customer
                + "\",\"debitaccount\":\"" + debitaccount + "\",\"effective\":\""
                + effective + "\", \"order\":\"" + order + "\", \"remarks\":\""
                + remarks + "\"}";

    }

}

package com.spearhead.nova.model.pojoClasses;

import java.io.Serializable;

public class SendMailTo implements Serializable {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SendMailTo(String email) {
        this.email = email;
    }

    // @Override
    // public String toString() {
    // return "SendMailTo [email=" + email + "]";
    // }

    @Override
    public String toString() {
        return "{\"email\":\"" + email + "\"}";
    }

}

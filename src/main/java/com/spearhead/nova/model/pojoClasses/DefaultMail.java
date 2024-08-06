package com.spearhead.nova.model.pojoClasses;

import java.util.ArrayList;

public class DefaultMail {

    private String message;
    private String subject;

    private ArrayList<SendMailTo> to = new ArrayList<>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public ArrayList<SendMailTo> getTo() {
        return to;
    }

    public void setTo(ArrayList<SendMailTo> to) {
        this.to = to;
    }

    public DefaultMail(String message, String subject, ArrayList<SendMailTo> to) {
        this.message = message;
        this.subject = subject;
        this.to = to;
    }

    // @Override
    // public String toString() {
    // return "DefaultMail [message=" + message + ", subject=" + subject + ", to=" +
    // to + "]";
    // }

    @Override
    public String toString() {
        return "{\"message\":\"" + message + "\", \"subject\":\"" + subject + "\",\"to\": " + to + "}";
    }

}
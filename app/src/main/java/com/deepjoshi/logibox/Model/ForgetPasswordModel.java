package com.deepjoshi.logibox.Model;

/**
 * Created by SONY on 18-03-2017.
 */

public class ForgetPasswordModel {

    /**
     * status : 1
     * message : Your password has been sent to your registered Email-id.
     */

    private int status;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
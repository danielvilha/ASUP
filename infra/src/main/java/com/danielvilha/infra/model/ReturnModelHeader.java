package com.danielvilha.infra.model;

/**
 * Created by danielvilha.
 */

public class ReturnModelHeader {

    private String httpStatus;

    private Object message;

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}

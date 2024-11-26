package com.luv2code.demo.rest;

public class StudentErrorResponse {
    private int errorCode;
    private String errorMessage;
    private long errorTimeStamp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int errorCode, String errorMessage, long errorTimeStamp) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorTimeStamp = errorTimeStamp;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public long getErrorTimeStamp() {
        return errorTimeStamp;
    }

    public void setErrorTimeStamp(long errorTimeStamp) {
        this.errorTimeStamp = errorTimeStamp;
    }

    @Override
    public String toString() {
        return "StudentErrorResponse{" +
                "errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorTimeStamp=" + errorTimeStamp +
                '}';
    }
}

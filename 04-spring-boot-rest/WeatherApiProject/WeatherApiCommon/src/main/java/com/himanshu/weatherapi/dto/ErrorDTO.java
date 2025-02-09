package com.himanshu.weatherapi.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorDTO {
    private Date timestamp;
    private int status;
    private String path;
    private List<String> error;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getError() {
        return error;
    }

    public void addError(String error) {
        if (this.error == null) {
            this.error = new ArrayList<>();
        }
        this.error.add(error);
    }
}

package com.himanshu.springbootrest.entity;

import java.time.LocalDateTime;

public class Response {
    private String message;
    private String date;

    public Response(String message) {
        this.message = message;
        this.date = LocalDateTime.now().toString();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

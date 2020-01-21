package com.example.donationapp.POJO;

public class DefaultRes {
    private boolean error;
    private String message;

    public DefaultRes(boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}

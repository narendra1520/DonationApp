package com.example.donationapp.POJO;

public class LoginRes {
    private boolean error;
    private String message;
    private User data;

    public LoginRes(boolean error, String message, User data) {
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return data;
    }
}

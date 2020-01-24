package com.example.donationapp;

import android.util.Patterns;

public class Validator{
    public static String emialValid(String email){
        if(email.isEmpty()){
            return "Required";
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return "enter valid email";
        }else {
            return null;
        }
    }

    public static String nameValid(String name){
        if(name.isEmpty()){
            return "Required";

        }else {
            return null;
        }
    }

    public static String addressValid(String address){
        if(address.isEmpty()){
            return "Required";

        }else {
            return null;
        }
    }

    public static String moreeditValid(String edit){
        if(edit.isEmpty()){
            return "Required";

        }else {
            return null;
        }
    }

    public static String mobileValid(String mobile){
        String MobilePattern = "[0-9]{10}";
        if(mobile.isEmpty()){
            return "Required";
        }else if (mobile.length()!=10){
            return "length must be in 10";}
        else if (mobile.matches(MobilePattern))
        {
            return null;
        }
        else {
            return "enter valid mobile no.";
        }
    }
    public static String amountValid(String amount){
        String amountPattern = "[0-9]{10}";
        if(amount.isEmpty()){
            return "Required";
        }else if (amount.matches(amountPattern))
        {
            return null;
        }
        else {
            return "enter valid amount";
        }
    }


    public static String passValid(String pass){
        if(pass.isEmpty()){
            return "Required";
        }else if (pass.length()<6){
            return "length must be in 6 or more";
        }else {
            return null;
        }
    }
}


package com.example.donationapp.POJO;

public class NGOHolder {
    private static final NGOHolder ngoHolder = new NGOHolder();
    private NGO ngo = null;

    public static NGOHolder getInstance() {
        return ngoHolder;
    }

    public NGO getNgo() {
        return ngo;
    }

    public void setNgo(NGO ngo) {
        this.ngo = ngo;
    }
}

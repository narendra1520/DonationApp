package com.example.donationapp.POJO;

public class Coll {
    String name, address, tag;

    public Coll(String name, String address, String tag) {
        this.name = name;
        this.address = address;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTag() {
        return tag;
    }
}

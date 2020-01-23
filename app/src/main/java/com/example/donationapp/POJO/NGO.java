package com.example.donationapp.POJO;

public class NGO {
    String name, address, type, tag;

    public NGO(String name, String address, String type, String tag) {
        this.name = name;
        this.address = address;
        this.tag = tag;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public String getTag() {
        return tag;
    }
}

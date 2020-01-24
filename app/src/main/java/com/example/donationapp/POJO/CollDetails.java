package com.example.donationapp.POJO;

public class CollDetails {
    String name, address, contact, email, gmap, toatl_donation ,tag;

    public CollDetails(String name, String address, String contact, String email, String gmap, String toatl_donation, String tag) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.gmap = gmap;
        this.toatl_donation = toatl_donation;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getGmap() {
        return gmap;
    }

    public String getToatl_donation() {
        return toatl_donation;
    }

    public String getTag() {
        return tag;
    }
}

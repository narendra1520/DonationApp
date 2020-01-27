package com.example.donationapp.POJO;

public class CollDetails {
    String name, address, tag, contact, email, gmap, toatl_donation;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTag() {
        return tag;
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

    public CollDetails(String name, String address, String tag, String contact, String email, String gmap, String toatl_donation) {
        this.name = name;
        this.address = address;
        this.tag = tag;
        this.contact = contact;
        this.email = email;
        this.gmap = gmap;
        this.toatl_donation = toatl_donation;
    }
}

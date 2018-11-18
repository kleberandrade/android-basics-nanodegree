package com.udacity.project.tourguide.models;

public class School {

    private final String name;
    private final String address;
    private final String phone;
    private final int imageId;

    public School(String name, String address, String phone, int imageId) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getImageId() {
        return imageId;
    }

}
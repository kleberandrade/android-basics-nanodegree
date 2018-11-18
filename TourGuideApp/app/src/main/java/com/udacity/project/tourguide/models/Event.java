package com.udacity.project.tourguide.models;

public class Event {

    private final String name;
    private final String date;
    private final int imageId;

    public Event(String name, String date, int imageId) {
        this.name = name;
        this.date = date;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getImageId() {
        return imageId;
    }

}

package com.udacity.project.tourguide.models;

public class News {

    private final String title;
    private final String date;

    public News(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

}

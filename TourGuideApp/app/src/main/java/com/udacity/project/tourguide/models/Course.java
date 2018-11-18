package com.udacity.project.tourguide.models;

public class Course {

    private final String name;
    private final String description;

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

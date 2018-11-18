package com.project.udacity.freemusicapp.models;

public class Music {

    private final String artistName;
    private final String trackTitle;
    private final String trackLength;

    public Music(String artistName, String trackTitle, String trackLength) {
        this.artistName = artistName;
        this.trackTitle = trackTitle;
        this.trackLength = trackLength;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public String getTrackLength() {
        return trackLength;
    }
}

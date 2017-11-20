package com.example.ahsan.firebaserealtimedatabase;

/**
 * Created by Ahsan on 11/20/2017.
 */

public class Track {

    private String trackId;
    private String trackNmae;
    private int trackRating;

    public Track(){

    }

    public Track(String trackId, String trackNmae, int trackRating) {
        this.trackId = trackId;
        this.trackNmae = trackNmae;
        this.trackRating = trackRating;
    }

    public String getTrackId() {
        return trackId;
    }

    public String getTrackNmae() {
        return trackNmae;
    }

    public int getTrackRating() {
        return trackRating;
    }
}

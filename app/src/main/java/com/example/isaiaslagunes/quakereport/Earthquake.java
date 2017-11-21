package com.example.isaiaslagunes.quakereport;

import android.app.LoaderManager;

/**
 * Created by Isaias Lagunes on 11/17/2017.
 */
public class Earthquake {
    public double magnitude;
    public String location;
    public long hour;
    public String url;

    public Earthquake(double magnitude, String location, long hour, String url) {
        this.magnitude = magnitude;
        this.location = location;
        this.hour = hour;
        this.url = url;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getHour() {
        return hour;
    }

    public void setHour(long hour) {
        this.hour = hour;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

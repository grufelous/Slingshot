package com.iondew.slingshot;

public abstract class HelperClass {
    private double latFactor, lonFactor;
    public double latToMeters(double lat) {
        return lat*latFactor;
    }
    public double lonToMeters(double lon) {
        return lon*lonFactor;
    }
}

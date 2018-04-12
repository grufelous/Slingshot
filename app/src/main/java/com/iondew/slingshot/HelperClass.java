package com.iondew.slingshot;

public abstract class HelperClass {
    private static double latFactor = 1, lonFactor = 1;
    public static double latToMeters(double lat) {
        return lat*latFactor;
    }
    public static double lonToMeters(double lon) {
        return lon*lonFactor;
    }
}

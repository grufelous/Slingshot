package com.iondew.slingshot;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.lang.Math;
import java.util.ArrayList;

import static java.lang.Math.atan2;
import static java.lang.Math.floor;
import static java.lang.Math.sin;

public abstract class HelperClass {
    private static double latFactor = 110567, lonFactor = 1;    //to convert the degrees to meters
    private static String TAG = "HELP";

    public static double latToMeters(double lat) {
        return lat*latFactor;
    }
    public static double lonToMeters(double lon) {
        return lon*lonFactor;
    }

    public static double getDistanceFromLatLonInM ( double lat1, double lon1, double lat2, double lon2){
        double R = 6371137; // Radius of the earth in m
        double dLat = deg2rad(lat2 - lat1);  // deg2rad below
        double dLon = deg2rad(lon2 - lon1);
        double a =
                sin(dLat / 2) * sin(dLat / 2) +
                        Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                                sin(dLon / 2) * sin(dLon / 2);
        double c = 2 * atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c; // Distance in m
        return d;
    }

    public static double deg2rad ( double deg){
        return (deg * (Math.PI / 180));
    }

    public static boolean inBounds(LatLng userLoc, LatLng stationLoc) {
        boolean isItInBounds = false;
        if(getDistanceFromLatLonInM(userLoc.latitude, userLoc.longitude, stationLoc.latitude, stationLoc.longitude) <= 200) {
            isItInBounds = true;
        }
        return isItInBounds;
    }

    public static LatLng nearestMetro(LatLng user) {
        LatLng metroNearest = new LatLng(0,0);
        StationList sl = new StationList();
        ArrayList<Station> yellow_stations = sl.yellow_stations;
        Log.d(TAG, "Size of yellow " + yellow_stations.size());
        Station nearestStat = yellow_stations.get(0);
        double closestDist = getDistanceFromLatLonInM(yellow_stations.get(0).getCoordinates().latitude, yellow_stations.get(0).getCoordinates().longitude,
                user.latitude, user.longitude);
        Log.d(TAG, "nearestMetro: Init");
        for (Station s: yellow_stations) {

            double dist = getDistanceFromLatLonInM(s.getCoordinates().latitude, s.getCoordinates().longitude, user.latitude, user.longitude);
            if(dist < closestDist) {
                closestDist = dist;
                //Toast.makeText(MapsActivity2, "Updated distance to \" + closestDist + \" for \" + s.getName()", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "nearestMetro: " + closestDist + s.getName() + "is nearest so far");
                nearestStat = s;
            }
        }
        Log.d(TAG, "nearestMetro: " + nearestStat.getName());
        return metroNearest;
    }
}

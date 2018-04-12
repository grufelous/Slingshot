package com.iondew.slingshot;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import static com.iondew.slingshot.HelperClass.latToMeters;
import static com.iondew.slingshot.HelperClass.lonToMeters;


public class Station {
    private String name;
    private int index, numStations;
    private LatLng coordinates;
    private boolean connector = false, terminal = false;
    private ArrayList<String> colors = new ArrayList<>();

    public Station(int index, int numStations, String name, ArrayList<String> colors, double lat, double lon) {

    }

    public Station(int i, int i1, boolean blue, double v, double v1) {
    }

    public boolean isConnector() {
        return connector;
    }

    public boolean isTerminal() {
        return terminal;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public boolean isColor(String colorToCheck) {
        boolean isIt = false;
        if (colors.contains(colorToCheck)) {
            isIt = true;
        }
        return isIt;
    }

    public boolean inBounds(LatLng userLoc) {
        boolean inBounds = false;
        inBounds = HelperClass.inBounds(userLoc, coordinates);
        return inBounds;
    }
}

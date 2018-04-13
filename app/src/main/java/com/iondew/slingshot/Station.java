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
        this.index = index;
        this.numStations = numStations;
        this.name = name;
        this.colors = colors;
        this.coordinates = new LatLng(lat, lon);
        if(colors.size() > 1) {
            connector = true;
        }
        if((index == 0) || (numStations == index+1)) {
            terminal = true;
        }
    }

    public String getName() {
        return this.name;
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

    public LatLng getCoordinates() {
        return coordinates;
    }

    public boolean isColor(String colorToCheck) {
        boolean isIt = false;
        if (colors.contains(colorToCheck)) {
            isIt = true;
        }
        return isIt;
    }

    public int getIndex() {
        return index;
    }

    public boolean inBounds(LatLng userLoc) {
        boolean inBounds = false;
        inBounds = HelperClass.inBounds(userLoc, coordinates);
        return inBounds;
    }
}

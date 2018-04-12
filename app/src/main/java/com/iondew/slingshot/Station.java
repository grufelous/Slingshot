package com.iondew.slingshot;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class Station {
    private String name;
    private int index, numStations;
    private LatLng coordinates;
    private boolean connector = false, terminal = false;
    private ArrayList<String> colors = new ArrayList<>();

    public Station(int index, int numStations, String name, ArrayList<String> colors, double lat, double lon) {
        this.index = index;
        this.numStations = numStations;
        if((index == 0) || (index+1 == numStations)) {
            terminal = true;
        }
        if(colors.size() > 1) {
            connector = true;
        }
        this.coordinates = new LatLng(lat, lon);
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
}

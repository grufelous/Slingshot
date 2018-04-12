package com.iondew.slingshot;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class Station {
    private String name;
    private int index, numStations;
    private LatLng coordinates;
    private boolean isConnector = false, isTerminal = false;
    private ArrayList<String> colors = new ArrayList<>();

    public Station(int index, int numStations, String name, ArrayList<String> colors, double lat, double lon) {
        this.index = index;
        this.numStations = numStations;
        if((index == 0) || (index+1 == numStations)) {
            isTerminal = true;
        }
        if(colors.size() > 1) {
            isConnector = true;
        }
        this.coordinates = new LatLng(lat, lon);

    }
}

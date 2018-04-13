package com.iondew.slingshot;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Looper;
import android.os.VibrationEffect;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Vibrator;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener {
    private static String TAG = "HELP";
    private GoogleMap mMap;
    private LocationManager locationManager;
    private Button pathFixed;
    private Station myStation;
    LocationRequest mLocationRequest;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    FusedLocationProviderClient mFusedLocationClient;
    StationList sl = new StationList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myStation = sl.yellow_stations.get(7);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        pathFixed = findViewById(R.id.path_button);
        pathFixed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Station fixedDemo = sl.yellow_stations.get(2);
                showPath(fixedDemo, myStation);
            }
        });
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        try {
            LatLng presentLoc = new LatLng(-34, 151);
            mMap.addMarker(new MarkerOptions().position(presentLoc).title("Marker on you"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(presentLoc));
            //mMap.moveCamera(CameraUpdateFactory.newLatLng(mMap.));
            mLocationRequest = new LocationRequest();
            mLocationRequest.setSmallestDisplacement(50);
            //mLocationRequest.setInterval(2000);
            mLocationRequest.setFastestInterval(2000);
            mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

            mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());

            mMap.setMyLocationEnabled(true);
            mMap.setOnMyLocationButtonClickListener(this);
            mMap.setOnMyLocationClickListener(this);
            //calculate nearest metro
            LatLng nearest = HelperClass.nearestMetro(presentLoc);
            Log.d(TAG, "onMapReady: " + presentLoc.longitude + " " + presentLoc.latitude);
            Toast.makeText(this, "Closest to  " + nearest.longitude + ", " + nearest.latitude, Toast.LENGTH_SHORT).show();
        } catch (SecurityException s) {
            Log.d(TAG, "onMapReady: SecurityException reached");
        }
    }

    public void showPath(Station destStation, Station myStation) {
        mMap.addMarker(new MarkerOptions().position(destStation.getCoordinates()).title(destStation.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(destStation.getCoordinates(), 11));
        //mLocationRequest.setInterval(160000);
        Toast.makeText(this, "Added a marker for INA!", Toast.LENGTH_SHORT).show();
        Vibrator v;

        PolylineOptions pathSoFar = new PolylineOptions();
        ArrayList<Station> yellowsInBetween = new ArrayList<Station>();
        int spaces = destStation.getIndex() - myStation.getIndex();
        if(spaces < 0) {
            for(int i = destStation.getIndex(); i <= myStation.getIndex(); i++) {
                yellowsInBetween.add(sl.yellow_stations.get(i));
                pathSoFar.add(sl.yellow_stations.get(i).getCoordinates());
            }
        } else if(spaces > 0) {
            for(int i = destStation.getIndex(); i >= myStation.getIndex(); i++) {
                yellowsInBetween.add(sl.yellow_stations.get(i));
                pathSoFar.add(sl.yellow_stations.get(i).getCoordinates());
            }
        } else {
            Toast.makeText(this, "Destination reached!", Toast.LENGTH_LONG).show();
            v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 500 milliseconds
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(1000,VibrationEffect.DEFAULT_AMPLITUDE));
            }else{
                //deprecated in API 26
                v.vibrate(1000);
            }
        }

        Polyline path = mMap.addPolyline(pathSoFar);
    }

    /*private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            mMap.setMyLocationEnabled(true);
            // Check if we were successful in obtaining the map.
            if (mMap != null) {


                mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {

                    @Override
                    public void onMyLocationChange(Location arg0) {
                        // TODO Auto-generated method stub

                        mMap.showPath(new MarkerOptions().position(new LatLng(arg0.getLatitude(), arg0.getLongitude())).title("It's Me!"));
                    }
                });

            }
        }
    }*/

    LocationCallback mLocationCallback = new LocationCallback(){
        @Override
        public void onLocationResult(LocationResult locationResult) {
            for (Location location : locationResult.getLocations()) {
                Log.i("MapsActivity", "Location: " + location.getLatitude() + " " + location.getLongitude());
                mLastLocation = location;
                if (mCurrLocationMarker != null) {
                    mCurrLocationMarker.remove();
                }

                //Place current location marker
                Log.d(TAG, "onLocationResult: " + location.getLatitude() + " " + location.getLongitude());
                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title("Current Position");
                markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
                mCurrLocationMarker = mMap.addMarker(markerOptions);

                //move map camera
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14));


            }
        }
    };


    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {

        Toast.makeText(this, "lat, lon: " + location.getLatitude() + ", " + location.getLongitude(), Toast.LENGTH_LONG).show();
    }
}

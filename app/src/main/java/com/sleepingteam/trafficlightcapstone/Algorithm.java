package com.sleepingteam.trafficlightcapstone;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Algorithm extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Marker marker1,marker2,marker3,marker4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
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

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        final LatLng chandigarh = new LatLng(30.717891, 76.812386);
//        mMap.addMarker(new MarkerOptions().position(chandigarh).title("chandigarh"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chandigarh, 15));
        googleMap.setTrafficEnabled(true);
        marker1 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(30.717875, 76.812207))
                .title("transport lights")
                .snippet("Population: 776733"));
        marker2 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(30.718034, 76.812361))
                .title("transport lights")
                .snippet("Population: 776733"));
        marker3 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(30.717916, 76.812551))
                .title("transport lights")
                .snippet("Population: 776733"));
        marker4 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(30.717749, 76.812398))
                .title("transport lights")
                .snippet("Population: 776733"));
        timer_calculation();

    }

    private void timer_calculation() {
        //after some t1 seoonds set the change the color of the marker
        //change marker color
        marker1.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

    }
}

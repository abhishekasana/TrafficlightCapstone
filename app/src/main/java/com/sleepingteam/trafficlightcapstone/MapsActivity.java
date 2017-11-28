package com.sleepingteam.trafficlightcapstone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Spinner dropdown = (Spinner)findViewById(R.id.spinner);
        String[] items = new String[]{"choose day", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        Button process_algo = (Button) findViewById(R.id.algorithm);
        process_algo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this,Algorithm.class);
                startActivity(intent);
            }
        });
        SeekBar seekBar = (SeekBar)findViewById(R.id.seekbar);
        final TextView seekbar_progress = (TextView)findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                               @Override
                                               public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                                                   int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                                                   seekbar_progress.setText(" " + progress);
                                                   seekbar_progress.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
                                                   seekbar_progress.setY(50);
                                                   //textView.setY(100); just added a value set this properly using screen with height aspect ratio , if you do not set it by default it will be there below seek bar

                                               }

                                               @Override
                                               public void onStartTrackingTouch(SeekBar seekBar) {

                                               }

                                               @Override
                                               public void onStopTrackingTouch(SeekBar seekBar) {

                                               }


                                           });
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
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        final LatLng chandigarh = new LatLng(30.734472, 76.780006);
//        mMap.addMarker(new MarkerOptions().position(chandigarh).title("chandigarh"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chandigarh, 15));
        googleMap.setTrafficEnabled(true);
    }
}

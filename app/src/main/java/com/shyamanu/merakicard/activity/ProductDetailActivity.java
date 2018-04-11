package com.shyamanu.merakicard.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.shyamanu.merakicard.R;
import com.shyamanu.merakicard.utils.GpsTracker;

/**
 * Created by shwettank.ramteke on 3/29/2018.
 */

public class ProductDetailActivity extends AppCompatActivity implements View.OnClickListener {

    // Google Map
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    private GpsTracker gps;
    private double latitude;
    private double longitude;
    private double destinationLatitude;
    private double destinationLongitude;
    private LatLng curentpoint;
    private Button btnUploadBill = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product_detail);
        // initialize components
        initViews();

        // add listener
        addListener();

        try {
            // Loading map
            initializeMap();

            // Calling a Async Background thread
            // setGooglePlacesDetails();

        } catch (Exception e) {
            e.printStackTrace();
        }
     }


    /**
     * initialize components
     */
    private void initViews() {
        btnUploadBill = (Button) findViewById(R.id.buttonUploadBill);
    }

    private void addListener() {
     btnUploadBill.setOnClickListener(this);
    }

    /**
     * function to load map. If map is not created it will create it for you
     */
    private void initializeMap() {
        try {
            if (mMap == null) {
                mMap = ((MapFragment) getFragmentManager().findFragmentById(
                        R.id.map)).getMap();


                // check if map is created successfully or not
                if (mMap == null) {
                    Toast.makeText(getApplicationContext(),
                            "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                            .show();
                }
            }

            gps = new GpsTracker(getApplicationContext());
            gps.canGetLocation();

        latitude = gps.getLatitude();
        longitude = gps.getLongitude();

            // Atlanta, Georgia Lat long
           /* latitude = 33.844212;
            longitude = -84.316052;*/

            latitude = 21.194440;
            longitude = 79.100004;

            curentpoint = new LatLng(latitude, longitude);
            destinationLatitude = 33.846355;
            destinationLongitude = -84.310917;
            LatLng latLng2 = new LatLng(destinationLatitude, destinationLongitude);

            /*destinationMarker = mMap.addMarker(new MarkerOptions()
                    .position(latLng2)
                    //  .snippet(placeName)
                    .title(placeName)
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.destination_location_pin)));*/

            /**
             * plot route between source and destination
             **/
            //plottingRoute();

            // create marker
            MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title("This is you");
            // Changing marker icon
            marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.source_location_pin));
            // adding marker
            mMap.addMarker(marker);

            CameraPosition cameraPosition = new CameraPosition.Builder().target(
                    new LatLng(latitude, longitude)).zoom(11).build();

            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }catch(Exception e){
            Log.e("Exception",e.toString());
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        //   setUpMap();
        initializeMap();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonUploadBill:
                Intent uploadBillIntent = new Intent(ProductDetailActivity.this,CategoryActivity.class);
                startActivity(uploadBillIntent);
                break;

            default:
                break;
        }
    }
}

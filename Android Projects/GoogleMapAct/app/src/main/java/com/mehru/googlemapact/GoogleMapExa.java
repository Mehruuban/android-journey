package com.mehru.googlemapact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.mehru.googlemapact.databinding.ActivityGoogleMapExaBinding;

import java.io.IOException;
import java.util.ArrayList;

public class GoogleMapExa extends AppCompatActivity {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map_exa);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync((OnMapReadyCallback) this);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                                            .findFragmentById(R.id.map);

        assert mapFragment != null;
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {

                mMap = googleMap;

                 //Marker is Used For Show Locations (Restaurants,Shops)

                LatLng latLngM = new LatLng(28.381159, 78.114769);
                MarkerOptions markerOptions = new MarkerOptions().position(latLngM).title("JIT college");
                mMap.addMarker(markerOptions);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngM));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLngM,16f));


                //Circle Overlay (adding overlay in google map)
                //Circles Used for   Show radius-based areas (danger zones, service coverage).

                mMap.addCircle(new CircleOptions()
                        .center(latLngM)
                        .radius(1000f)
                        .fillColor(Color.GREEN)
                        .strokeColor(Color.DKGRAY));

                //Polygon     is Used for  Highlight areas (zones, boundaries).

                mMap.addPolygon(new PolygonOptions()
                        .add(new LatLng(28.381159, 78.114769),
                           new LatLng(28.381159, 78.114769),
                           new LatLng(28.381159, 78.114769))
                        .fillColor(Color.YELLOW)
                        .strokeColor(Color.BLUE));


                //Image Overlay or Ground Overly  is Used for Add custom images (logos, watermarks).
                mMap.addGroundOverlay(new GroundOverlayOptions()
                        .position(latLngM,1000f,1000f)
                        .image(BitmapDescriptorFactory.fromResource(R.drawable.androidicon))
                        .clickable(true));


            //To Use geocode class
               mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                   @Override
                   public void onMapClick(@NonNull LatLng latLng) {

                       MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Click Here");
                       mMap.addMarker(markerOptions);
                       mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                       mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,16f));

                       Geocoder geocoder = new Geocoder(GoogleMapExa.this);
                       try {
                           ArrayList<Address> arrayList = (ArrayList<Address>) geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                           assert arrayList != null;
                           Log.d("address",arrayList.get(0).getAddressLine(0));
                       } catch (IOException e) {
                           throw new RuntimeException(e);
                       }

                   }
               });
//                Geocoder geocoder = new Geocoder(GoogleMapExa.this);
//                try {
//                 ArrayList<Address> arrayList = (ArrayList<Address>) geocoder.getFromLocation(26.7845, 80.9913, 1);
//                    Log.d("address",arrayList.get(0).getAddressLine(0));
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }


            }
        });




    }
}
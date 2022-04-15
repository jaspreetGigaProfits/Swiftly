package com.example.capstone_the_developers;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class CovidLocationFragment extends Fragment {

    LatLng long_and_lat1,long_and_lat2,long_and_lat3,long_and_lat4,long_and_lat5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater. inflate(R.layout.fragment_covid_location, container, false);

        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.mapView);

        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(@NonNull LatLng latLng) {
                        MarkerOptions markerOptions = new MarkerOptions();
                        long_and_lat1 = new LatLng(43.773493133357725, -79.33607891560074);
                        long_and_lat2 = new LatLng(43.726178583754916, -79.33686623069292);
                        long_and_lat3 = new LatLng(43.681836956005014, -79.41843469999999);
                        long_and_lat4 = new LatLng(43.759440478237465, -79.51605765767324);
                        long_and_lat5 = new LatLng(43.7226394493575, -79.51078172883663);
                            googleMap.addMarker(new MarkerOptions().position(long_and_lat1).title("2494 Danforth Ave, Toronto, ON M4C 1K9"));
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                                    long_and_lat1, 10));
                        googleMap.addMarker(new MarkerOptions().position(long_and_lat2).title("57 Gervais Drive,North York,M3C 1Z2,ON"));
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                                long_and_lat2, 10));
                        googleMap.addMarker(new MarkerOptions().position(long_and_lat3).title("22 Vaughan Road,Toronto,M6G 2N1,ON"));
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                                long_and_lat3, 10));
                        googleMap.addMarker(new MarkerOptions().position(long_and_lat4).title("15 San Romanoway,Toronto,M3N 2Y9,ON"));
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                                long_and_lat4, 10));
                        googleMap.addMarker(new MarkerOptions().position(long_and_lat5).title("2202 Jane Street, Unit 5,Toronto,M3N 3A1,ON"));
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                                long_and_lat5, 10));


                    }
                });
            }
        });
        return view;
    }
}
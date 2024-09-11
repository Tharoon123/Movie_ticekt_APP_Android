package com.example.bookmyticket;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.zip.Inflater;


public class FindFragment extends Fragment {
    int fineCode=1;
    GoogleMap gmap;
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_find, container,false);




        SupportMapFragment suppmapFragment=(SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        suppmapFragment.getMapAsync(new OnMapReadyCallback() {
            @SuppressLint("MissingPermission")
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                LatLng [] pvrlocations = new LatLng[4];

                pvrlocations[0] = new LatLng(6.9271,79.8612);
                pvrlocations[1] = new LatLng(6.9270,79.8640);
                pvrlocations[2] = new LatLng(6.9122,79.8829);
                pvrlocations[3] = new LatLng(6.8980,79.9223);



                googleMap.addMarker(new MarkerOptions().position(pvrlocations[0]).title("PVR Cicema 01"));
                googleMap.addMarker(new MarkerOptions().position(pvrlocations[1]).title("PVR Cicema 02"));
                googleMap.addMarker(new MarkerOptions().position(pvrlocations[2]).title("PVR Cicema 03"));
                googleMap.addMarker(new MarkerOptions().position(pvrlocations[3]).title("PVR Cicema 04"));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(pvrlocations[0],15));


                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

                    @Override
                    public void onMapClick(@NonNull LatLng latLng) {

                        MarkerOptions markerOptions =new MarkerOptions();
                        markerOptions.position(latLng);
                        markerOptions.title(latLng.latitude + ":" + latLng.longitude);

                        googleMap.clear();
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                                latLng,10
                        ));
                        googleMap.addMarker(markerOptions);

                    }

                });


            }
        });

        return view;




    }




}
package com.example.finalvideojuegos20212;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.finalvideojuegos20212.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private final static int GPS_REQUEST_CODE_PERMISSION = 10001;

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    public String par1;
    public String par2;
    public String nombreitem;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String Localizacion=getIntent().getStringExtra("ubic");
        nombreitem=getIntent().getStringExtra("nombre");
        String[] loc=Localizacion.split(",");
         par1=loc[0];
         par2=loc[1];


        //verificar si los permisos existen
        if (!hasGPSPermission()) {
            //solicitar los permisos
            requestPermissions(new String[] {
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            }, GPS_REQUEST_CODE_PERMISSION);
        }

        LocationManager mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 1, this);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this::onMapReady);
    }

    private boolean hasGPSPermission() {
        return checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
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
//
        LatLng ubicacion = new LatLng(Float.valueOf(par1),Float.valueOf(par2));
        mMap.addMarker(new MarkerOptions().position(ubicacion).title(nombreitem));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 18));
    }

    @Override
    public void onLocationChanged(Location location) {
        if(mMap != null) {
            LatLng currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
            mMap.addMarker(new MarkerOptions().position(currentLocation).title("Mi ubicación actual"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 6));
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
package com.example.admin.tabbedactivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

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
        LatLng sydney1 = new LatLng(13.030947, 80.171585);
        LatLng sydney2 = new LatLng(13.1298, 80.1537);
        LatLng sydney3 = new LatLng(13.0717, 80.2584);
        LatLng sydney4 = new LatLng(13.109593, 80.246666);
        mMap.addMarker(new MarkerOptions().position(sydney1).title("Vignesh Hospital"));
        mMap.addMarker(new MarkerOptions().position(sydney2).title("Thiruvallur government hospital"));
        mMap.addMarker(new MarkerOptions().position(sydney3).title(" Government Maternity hospital"));
        mMap.addMarker(new MarkerOptions().position(sydney3).title(" Srinivas Priya Hospital "));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney1));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney2));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney3));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney4));
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


    }
}

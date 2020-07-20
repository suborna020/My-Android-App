package bd.ac.seu.sixthapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback, OnSuccessListener<Location> {
    MapView mapView;
    GoogleMap googleMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_map);
        //map workszzz

        mapView=findViewById (R.id.googleMap);
        mapView.onCreate (savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onStart() {
        super.onStart ();
        //map innitial
        mapView.onStart ();
        checkPermissions();
        mapView.getMapAsync (this); //red line:MapActivity->select on map ready

    }
  //runtime permision for android

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void checkPermissions() {
        if(ContextCompat.checkSelfPermission (this,Manifest.permission.ACCESS_COARSE_LOCATION)== PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission (this,Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            mapView.getMapAsync (this);

        }else {

            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION},100001);//1000 my suppose
            }
        }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult (requestCode, permissions, grantResults);
        if (requestCode == 100001) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                mapView.getMapAsync (this);

            } else {
                Toast.makeText (this, "Permission not allowed", Toast.LENGTH_LONG).show ();
                //Toast.LENGTH_SHORT  :sort time toast made korlm
            }
        }
    }


    @Override
    protected void onResume() {
        super.onResume ();

        mapView.onResume ();
        getMyUpdatedLocation();
    }
//Getting last location  using getLastLocation ()
    private void getMyUpdatedLocation() {
        FusedLocationProviderClient locationManager = LocationServices.getFusedLocationProviderClient (this);
        if (ActivityCompat.checkSelfPermission (this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission (this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        locationManager.getLastLocation ().addOnSuccessListener (this);
    }

    @Override
    protected void onPause() {
        super.onPause ();
        mapView.onPause ();

    }

    @Override
    protected void onStop() {
        super.onStop ();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();
        mapView.onDestroy ();
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap=googleMap;
   //
        }

    @Override
    public void onSuccess(Location location) {
        //Map marker creating
        assert this.googleMap!=null;
        this.googleMap.addMarker (new MarkerOptions ()
                .position (new LatLng (location.getLatitude (),location.getLongitude ()))
                .title ("Here I am"));
        //23.7025455,90.4219168 google mapp theke amr recent place
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng (location.getLatitude (),location.getLongitude ())));

    }
}
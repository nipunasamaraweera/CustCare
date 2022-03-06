package com.example.custcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CurrentLocation extends AppCompatActivity {
    Button findL;
    Button Confirm;
    TextView textView1, textView2, textView3, textView4, textView5;
    EditText ACCno;
    FusedLocationProviderClient fusedLocationProviderClient;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_location);

        findL = findViewById(R.id.Find);
        Confirm = findViewById(R.id.Cnfrm);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        ACCno = findViewById(R.id.text6);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);


        findL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ActivityCompat.checkSelfPermission(CurrentLocation.this
                        , Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                    getLocation();
                } else {

                    ActivityCompat.requestPermissions(CurrentLocation.this
                            , new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);

                }
            }
        });


    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {

                Location location = task.getResult();
                if (location != null) {

                    try {
                        Geocoder geocoder = new Geocoder(CurrentLocation.this,
                                Locale.getDefault());
                        List<Address> addresses = geocoder.getFromLocation(
                                location.getLatitude(), location.getLongitude(), 1
                        );
                        textView1.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Latitude : </b><br></font>"
                                        + addresses.get(0).getLatitude()
                        ));
                        textView2.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Longitude : </b><br></font>"
                                        + addresses.get(0).getLongitude()
                        ));
                        textView3.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Country Name : </b><br></font>"
                                        + addresses.get(0).getCountryName()
                        ));
                        textView4.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Locality : </b><br></font>"
                                        + addresses.get(0).getLocality()
                        ));
                        textView5.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Address : </b><br></font>"
                                        + addresses.get(0).getAddressLine(0)
                        ));


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        });


        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode =FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Location");

                String Latitude = textView1.getText().toString();
                String Longitude = textView2.getText().toString();
                String Country = textView3.getText().toString();
                String Locality = textView4.getText().toString();
                String Address = textView5.getText().toString();
                String accountNumber = ACCno.getText().toString();

                AddL location = new AddL(Latitude,Longitude,Country,Locality, Address, accountNumber);

                reference.child(accountNumber).setValue(location);

                startActivity(new Intent(getApplicationContext(),home2.class));
            }
        });



    }

}


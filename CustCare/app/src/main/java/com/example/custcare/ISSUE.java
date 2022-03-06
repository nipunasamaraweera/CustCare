package com.example.custcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ISSUE extends AppCompatActivity {
    EditText accNO, Cname, Caddress, OaNo, tpNo, MID, houseNo, Tno, date, area;
    Button submitBtn, clearBtn, cancelBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_s_s_u_e);

        accNO = findViewById(R.id.AccNo);
        Cname = findViewById(R.id.CustomerName);
        Caddress = findViewById(R.id.Address);
        OaNo = findViewById(R.id.Other);
        tpNo = findViewById(R.id.Phone);
        MID = findViewById(R.id.MID);
        houseNo = findViewById(R.id.Hno);
        Tno = findViewById(R.id.Tno);
        date = findViewById(R.id.Date);
        area = findViewById(R.id.Area);
        submitBtn = findViewById(R.id.Submit);
        cancelBtn = findViewById(R.id.Cancel);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accNo = accNO.getText().toString().trim();
                String tpno = tpNo.getText().toString().trim();
                String cname = Cname.getText().toString().trim();
                String cad = Caddress.getText().toString().trim();
                String oano = OaNo.getText().toString().trim();
                String hno = houseNo.getText().toString().trim();
                String Ddate = date.getText().toString().trim();
                String Aare = area.getText().toString().trim();
                String tno = Tno.getText().toString().trim();
                String mid = MID.getText().toString().trim();


                if (TextUtils.isEmpty(accNo)) {
                    accNO.setError("Rquired");

                }

                if (TextUtils.isEmpty(tpno)) {
                    tpNo.setError("Rquired");

                }
                if (tpno.length() < 10) {
                    accNO.setError("Number must have 10 characters");

                }
                if (TextUtils.isEmpty(cname)) {
                    Cname.setError("Rquired");

                }
                if (TextUtils.isEmpty(cad)) {
                    Caddress.setError("Rquired");

                }
                if (TextUtils.isEmpty(oano)) {
                    OaNo.setError("Rquired");

                }
                if (TextUtils.isEmpty(hno)) {
                    houseNo.setError("Rquired");

                }
                if (TextUtils.isEmpty(Aare)) {
                    area.setError("Rquired");

                }
                if (TextUtils.isEmpty(tpno)) {
                    tpNo.setError("Rquired");

                }
                if (TextUtils.isEmpty(tno)) {
                    Tno.setError("Rquired");

                }
                if (TextUtils.isEmpty(mid)) {
                    MID.setError("Rquired");

                }

                rootNode =FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Issues");

                String ACCNO = accNO.getText().toString();
                String CNAME = Cname.getText().toString();
                String CADDRESS = Caddress.getText().toString();
                String OANO = OaNo.getText().toString();
                String tPNO = tpNo.getText().toString();
                String mID = MID.getText().toString();
                String HOUSENo = houseNo.getText().toString();
                String TNO = Tno.getText().toString();
                String DATE = date.getText().toString();
                String AREA = area.getText().toString();

                Addissue Issue = new Addissue(ACCNO, CNAME, CADDRESS, OANO, tPNO, mID, HOUSENo, TNO, DATE, AREA);


                reference.child(ACCNO).setValue(Issue);

               startActivity(new Intent(getApplicationContext(),CurrentLocation.class));


            }
        });





        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),home2.class));
            }
        });


    }
}
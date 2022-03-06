package com.example.custcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SignUp extends AppCompatActivity {

        EditText mname,marea,miD,mphonenumber,memail,mpassword;
        Button mRegisterBtn;
        Button mloginBtn;
        FirebaseAuth fAuth;
        FirebaseDatabase rootNode;
        DatabaseReference reference;

        private static final String DB_URL = "jdbc:mysql://sql12.freemysqlhosting.net/sql12378639";
        private static final String USER ="sql12378639";
        private static final String PASS = "tMHnJcQx4B";

        public void reg (View view)
        {
            Send objSend = new Send();
            objSend.execute("");
        }

        private class Send extends AsyncTask<String,String,String>
        {
            String msg = "";
            String name = mname.getText().toString();
            String telephone = mphonenumber.getText().toString();
            String email = memail.getText().toString();
            String iD  = miD.getText().toString();
            String password = mpassword.getText().toString();

            @Override
            protected String doInBackground(String... strings){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    if (conn == null) {
                        msg = "Connection goes wrong";
                    } else {
                        String query = "INSERT INTO meterreader(mrName,mrTelephone,mrEmail,mrID, mrPassword) VALUES ('" +name+ "','" + telephone + "','" + email + "','" + iD + "','" + password + "')";
                        Statement stmt = conn.createStatement();
                        stmt.executeUpdate(query);
                        msg = "Inserting Succesful";
                    }
                    conn.close();
                }
                catch (Exception e)
                {
                    msg = "connection goes wrong";
                    e.printStackTrace();
                }
                return msg;
            }

        }


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_up);

            mname = findViewById(R.id.Name);
            marea = findViewById(R.id.Area);
            miD   = findViewById(R.id.ID);
            mphonenumber = findViewById(R.id.PhoneNo);
            memail = findViewById(R.id.Email);
            mpassword = findViewById(R.id.Password);
            mRegisterBtn = findViewById(R.id.registerBtn);
            mloginBtn = findViewById(R.id.LoginBtn);
            fAuth = FirebaseAuth.getInstance();




            mRegisterBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String Email = memail.getText().toString().trim();
                    String Password = mpassword.getText().toString().trim();
                    String PhoneNo = mphonenumber.getText().toString().trim();

                    if(TextUtils.isEmpty(Email)){
                        memail.setError("Email is Required");
                        return;
                    }

                    if(TextUtils.isEmpty(Password)){
                        mpassword.setError("Password is Required");
                        return;
                    }
                    if(Password.length() < 6) {
                        mpassword.setError("Password Must Have 6 Characters");
                        return;
                    }
                    if(PhoneNo.length()<10){
                        mphonenumber.setError("Invalid Phone Number");
                        return;
                    }
                    fAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SignUp.this, "User Created.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            }else {
                                Toast.makeText(SignUp.this, "Error!"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }

                        }

                    });
                    rootNode =FirebaseDatabase.getInstance();
                    reference = rootNode.getReference("Users");

                    String name = mname.getText().toString();
                    String phonenumber = mphonenumber.getText().toString();
                    String email = memail.getText().toString();
                    String MID = miD.getText().toString();
                    String password = mpassword.getText().toString();
                    String area = marea.getText().toString();

                    AddUser User = new AddUser(name, phonenumber, email, MID, password, area);

                    reference.child(MID).setValue(User);


                }


            });
            mloginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
            });

           /* mRegisterBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rootNode =FirebaseDatabase.getInstance();
                    reference = rootNode.getReference("Users");

                    String name = mname.getText().toString();
                    String phonenumber = mphonenumber.getText().toString();
                    String email = memail.getText().toString();
                    String MID = miD.getText().toString();
                    String password = mpassword.getText().toString();
                    String area = marea.getText().toString();

                    AddUser User = new AddUser(name, phonenumber, email, MID, password, area);

                    reference.child(MID).setValue(User);
                }
            });*/
    }
}
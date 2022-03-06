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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText mEmail,mPassword;
    Button mLoginBtn;
    Button mRegstrBtn;
    Button mForgotPBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        fAuth = FirebaseAuth.getInstance();
        mLoginBtn = findViewById(R.id.LOGIN);
        mRegstrBtn = findViewById(R.id.NEWACC);
        mForgotPBtn = findViewById(R.id.CLICK);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is invalid");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Email is Rquired");
                    return;
                }
                if(password.length()<6) {
                    mPassword.setError("Password must have six characters");
                    return;
                }

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this,"Logged In",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), ISSUE.class));
                        } else{
                            Toast.makeText(MainActivity.this,"Error" + (task.getException()).getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        });
        mRegstrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUp.class));
            }
        });
        mForgotPBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Password.class));
            }
        });


    }
}
package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText ed1,ed2;
    ProgressBar progressBar;
    TextView textRegisterBtn;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.edEmail);
        ed2 = findViewById(R.id.edPassword);
        button = findViewById(R.id.login);
        textRegisterBtn = findViewById(R.id.registerBtn);
        progressBar = findViewById(R.id.progressBar2);
        fAuth = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = ed1.getText().toString().trim();
                String password = ed2.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    ed1.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    ed2.setError("Password is required");
                    return;
                }


                progressBar.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Login successful.",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MenuActivity.class));
                            progressBar.setVisibility(View.INVISIBLE);
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Error! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);

                        }
                    }
                });

            }
        });

        textRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });


    }
}
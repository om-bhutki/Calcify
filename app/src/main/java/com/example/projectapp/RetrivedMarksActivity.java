package com.example.projectapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class RetrivedMarksActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference,reference1,reference2;


    EditText ed1,ed2,ed3,ed4,edDate,ed5;
    String userEnteredEnroll,dateOfAttendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieve_all_values);

        firebaseDatabase = FirebaseDatabase.getInstance();
        ed1 = findViewById(R.id.enrollment_no);
        ed2 = findViewById(R.id.attendance_percent);
        ed3 = findViewById(R.id.avgTest);
        ed4 = findViewById(R.id.totalTermWork1);
        edDate = findViewById(R.id.month);
        ed5 = findViewById(R.id.presentDays);

        findViewById(R.id.dataBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getdata();
            }
        });

        findViewById(R.id.clearBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { clear(); }
        });


    }

    private void getdata() {
        userEnteredEnroll = ed1.getText().toString().trim();
        dateOfAttendance = edDate.getText().toString().trim();

        databaseReference = firebaseDatabase.getReference().child("Students").child(userEnteredEnroll).child("Attendance").child(dateOfAttendance);
        reference1 = firebaseDatabase.getReference().child("Students").child(userEnteredEnroll).child("Test");
        reference2 = firebaseDatabase.getReference().child("Students").child(userEnteredEnroll).child("Term Work");
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                    ed2.setText(datasnapshot.child("attendance_percentage").getValue(String.class));
                    Integer presentDays = datasnapshot.child("no_of_present_days").getValue(Integer.class);
                    ed5.setText(String.valueOf(presentDays));




                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(RetrivedMarksActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
                }
            });

            reference1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Double avg = snapshot.child("average_of_test").getValue(Double.class);
                    String avgString = avg + getString(R.string.outOf);
                    ed3.setText(avgString);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(RetrivedMarksActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();


                }
            });

            reference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    ed4.setText(snapshot.child("total_Term_Work_Marks").getValue(String.class));


                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(RetrivedMarksActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();


                }
            });




    }
    public void clear(){
        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
        ed4.setText("");
        ed5.setText("");
        edDate.setText("");
        ed1.requestFocus();


    }
}
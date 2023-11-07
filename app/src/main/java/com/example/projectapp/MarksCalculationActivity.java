package com.example.projectapp;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MarksCalculationActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed10,ed11;
    Button btn1,btn2;

    DatabaseReference reference;
    StudentDetails studentDetails;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks_calculation);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ed1 = findViewById(R.id.stName);
        ed2 = findViewById(R.id.test1);
        ed3 = findViewById(R.id.test2);
        ed10 = findViewById(R.id.total);
        ed11 = findViewById(R.id.avg);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        studentDetails = new StudentDetails();
        reference = FirebaseDatabase.getInstance().getReference().child("Students");

        btn1.setOnClickListener(new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View view) {

                                        marksCalculate();
                                    }
                                }
        );

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void marksCalculate(){
        int t1,t2;
        float total;
        float avg;
        String enrollment_no;
        enrollment_no = ed1.getText().toString().trim();



        if (!enrollment_no.startsWith("FCOG")){

            Toast.makeText(this,getString(R.string.enrollmentError),Toast.LENGTH_SHORT).show();

        }
        else {

            t1 = Integer.parseInt(ed2.getText().toString().trim());
            t2 = Integer.parseInt(ed3.getText().toString().trim());

            if ( t1 > 30 || t2 > 30) {
                Toast.makeText(this, getString(R.string.marksError), Toast.LENGTH_SHORT).show();

            } else {
                total = t1 + t2;
                String realTotal = Math.round(total) + getString(R.string.realTotal);
                ed10.setText(realTotal);

                avg = total / 2;

                ed11.setText(String.valueOf(avg));

                studentDetails.setTest1_marks(t1);
                studentDetails.setTest2_marks(t2);
                studentDetails.setTotal_of_test(realTotal);
                studentDetails.setAverage_of_test(avg);

                reference.child(enrollment_no).child("Test").setValue(studentDetails);


            }
        }
    }
    public void clear(){
        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
        ed10.setText("");
        ed11.setText("");
        ed1.requestFocus();

    }
}
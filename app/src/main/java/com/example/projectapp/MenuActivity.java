package com.example.projectapp;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_marks);
    }
    public void Attendance(View view){
        Intent intent = new Intent(this, AttendanceCalculationActivity.class);
        startActivity(intent);
    }

    public void Marks(View view){
        Intent intent = new Intent(this, MarksCalculationActivity.class);
        startActivity(intent);
    }
    public void TermWork(View view){
        Intent intent = new Intent(this, TermWorkCalculationActivity.class);
        startActivity(intent);
    }
    public void RetriveMarks(View view){
        Intent intent = new Intent(this,RetrivedMarksActivity.class);
        startActivity(intent);
    }
}

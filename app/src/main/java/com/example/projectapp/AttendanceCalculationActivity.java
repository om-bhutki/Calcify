package com.example.projectapp;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.math.BigDecimal;

public class AttendanceCalculationActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8,ed9,ed10,ed11,ed12,ed13,ed14,ed15,ed16,ed17,ed18,ed19,ed20,
            ed21,ed22,ed23,ed24,ed25,ed26,ed27,ed28,ed29,ed30,ed31,edp,edt;
    TextView dateText;

    Button button1,button2;
    DatabaseReference reference;
    StudentDetails studentDetails;
    String date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_calculation);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ed1 = findViewById(R.id.stName);
        ed2 = findViewById(R.id.d1);
        ed3 = findViewById(R.id.d2);
        ed4 = findViewById(R.id.d3);
        ed5 = findViewById(R.id.d4);
        ed6 = findViewById(R.id.d5);
        ed7 = findViewById(R.id.d6);
        ed8 = findViewById(R.id.d7);
        ed9 = findViewById(R.id.d8);
        ed10 = findViewById(R.id.d9);
        ed11 = findViewById(R.id.d10);
        ed12 = findViewById(R.id.d11);
        ed13 = findViewById(R.id.d12);
        ed14 = findViewById(R.id.d13);
        ed15 = findViewById(R.id.d14);
        ed16 = findViewById(R.id.d15);
        ed17 = findViewById(R.id.d16);
        ed18 = findViewById(R.id.d17);
        ed19 = findViewById(R.id.d18);
        ed20 = findViewById(R.id.d19);
        ed21 = findViewById(R.id.d20);
        ed22 = findViewById(R.id.d21);
        ed23 = findViewById(R.id.d22);
        ed24 = findViewById(R.id.d23);
        ed25 = findViewById(R.id.d24);
        ed26 = findViewById(R.id.d25);
        ed27 = findViewById(R.id.d26);
        ed28 = findViewById(R.id.d27);
        ed29 = findViewById(R.id.d28);
        ed30 = findViewById(R.id.d29);
        ed31 = findViewById(R.id.d30);
        edp = findViewById(R.id.percentage);
        edt = findViewById(R.id.totalAttendance);
        dateText = findViewById(R.id.date_text);

        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);

        studentDetails = new StudentDetails();
        reference = FirebaseDatabase.getInstance().getReference().child("Students");

        findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attendanceCalculation();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
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
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }
    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        int month = i1+1;
         date =  i + "/" + month;
         String dateComplete = getString(R.string.date) + ": " + date;
        dateText.setText(dateComplete);
        studentDetails.setDate(date);

    }

    public void attendanceCalculation(){

        String enrollment_no = ed1.getText().toString();

        if (!enrollment_no.startsWith("FCOG")){

            Toast.makeText(this,getString(R.string.enrollmentError),Toast.LENGTH_SHORT).show();

        }
        else {
            int numberOfPresent = 0;
            String[] d = new String[30];

            d[0] = ed2.getText().toString().trim();
            d[1] = ed3.getText().toString().trim();
            d[2] = ed4.getText().toString().trim();
            d[3] = ed5.getText().toString().trim();
            d[4] = ed6.getText().toString().trim();
            d[5] = ed7.getText().toString().trim();
            d[6] = ed8.getText().toString().trim();
            d[7] = ed9.getText().toString().trim();
            d[8] = ed10.getText().toString().trim();
            d[9] = ed11.getText().toString().trim();
            d[10] = ed12.getText().toString().trim();
            d[11] = ed13.getText().toString().trim();
            d[12] = ed14.getText().toString().trim();
            d[13] = ed15.getText().toString().trim();
            d[14] = ed16.getText().toString().trim();
            d[15] = ed17.getText().toString().trim();
            d[16] = ed18.getText().toString().trim();
            d[17] = ed19.getText().toString().trim();
            d[18] = ed20.getText().toString().trim();
            d[19] = ed21.getText().toString().trim();
            d[20] = ed22.getText().toString().trim();
            d[21] = ed23.getText().toString().trim();
            d[22] = ed24.getText().toString().trim();
            d[23] = ed25.getText().toString().trim();
            d[24] = ed26.getText().toString().trim();
            d[25] = ed27.getText().toString().trim();
            d[26] = ed28.getText().toString().trim();
            d[27] = ed29.getText().toString().trim();
            d[28] = ed30.getText().toString().trim();
            d[29] = ed31.getText().toString().trim();


            for (int i=0;i<d.length;i++){
                if (d[i].equals("P")){
                    numberOfPresent++;
                }
            }
            int noOfPresentDays = numberOfPresent;
            edt.setText(String.valueOf(noOfPresentDays));
            double attendance = numberOfPresent*100;
            double realAttendance = attendance/30;
            BigDecimal bigDecimal = new BigDecimal(realAttendance);
            BigDecimal roundedAttendance = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
            if (realAttendance<75){

                Toast.makeText(this,getString(R.string.defaulter),Toast.LENGTH_SHORT).show();
            }
            String finalAttendance = roundedAttendance + getString(R.string.attendance);
            edp.setText(finalAttendance);

            studentDetails.setDay1(d[0]);
            studentDetails.setDay2(d[1]);
            studentDetails.setDay3(d[2]);
            studentDetails.setDay4(d[3]);
            studentDetails.setDay5(d[4]);
            studentDetails.setDay6(d[5]);
            studentDetails.setDay7(d[6]);
            studentDetails.setDay8(d[7]);
            studentDetails.setDay9(d[8]);
            studentDetails.setDay10(d[9]);
            studentDetails.setDay11(d[10]);
            studentDetails.setDay12(d[11]);
            studentDetails.setDay13(d[12]);
            studentDetails.setDay14(d[13]);
            studentDetails.setDay15(d[14]);
            studentDetails.setDay16(d[15]);
            studentDetails.setDay17(d[16]);
            studentDetails.setDay18(d[17]);
            studentDetails.setDay19(d[18]);
            studentDetails.setDay20(d[19]);
            studentDetails.setDay21(d[20]);
            studentDetails.setDay22(d[21]);
            studentDetails.setDay23(d[22]);
            studentDetails.setDay24(d[23]);
            studentDetails.setDay25(d[24]);
            studentDetails.setDay26(d[25]);
            studentDetails.setDay27(d[26]);
            studentDetails.setDay28(d[27]);
            studentDetails.setDay29(d[28]);
            studentDetails.setDay30(d[29]);
            studentDetails.setNo_of_present_days(noOfPresentDays);
            studentDetails.setAttendance_percentage(finalAttendance);

            reference.child(enrollment_no).child("Attendance").child(studentDetails.getDate()).setValue(studentDetails);


        }
    }
    public void clear() {
        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
        ed4.setText("");
        ed5.setText("");
        ed6.setText("");
        ed7.setText("");
        ed8.setText("");
        ed9.setText("");
        ed10.setText("");
        ed11.setText("");
        ed12.setText("");
        ed13.setText("");
        ed14.setText("");
        ed15.setText("");
        ed16.setText("");
        ed17.setText("");
        ed18.setText("");
        ed19.setText("");
        ed20.setText("");
        ed21.setText("");
        ed22.setText("");
        ed23.setText("");
        ed24.setText("");
        ed25.setText("");
        ed26.setText("");
        ed27.setText("");
        ed28.setText("");
        ed29.setText("");
        ed30.setText("");
        ed31.setText("");
        edp.setText("");
        edt.setText("");
        dateText.setText("");
        ed1.requestFocus();
    }



}
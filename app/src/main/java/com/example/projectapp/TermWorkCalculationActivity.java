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


public class TermWorkCalculationActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8,ed9,ed10,ed11,ed12,ed13,ed14,ed15,ed16,ed17,ed18,ed19,ed20,ed21,
            ed22,ed23,ed24,ed25,ed26,ed27,ed28,ed29,ed30,ed31,edt1,edt2,edt3,edt4,edt5,edt6,edt7,edt8,edt9,edt10,edTotal;
    Button btn1,btn2;
    DatabaseReference reference;
    StudentDetails studentDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_work_calculation);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        ed1 = findViewById(R.id.stName);
        ed2 = findViewById(R.id.i1);
        ed3 = findViewById(R.id.i2);
        ed4 = findViewById(R.id.i3);
        ed5 = findViewById(R.id.i4);
        ed6 = findViewById(R.id.i5);
        ed7 = findViewById(R.id.i6);
        ed8 = findViewById(R.id.i7);
        ed9 = findViewById(R.id.i8);
        ed10 = findViewById(R.id.i9);
        ed11 = findViewById(R.id.i10);
        ed12 = findViewById(R.id.i11);
        ed13 = findViewById(R.id.i12);
        ed14 = findViewById(R.id.i13);
        ed15 = findViewById(R.id.i14);
        ed16 = findViewById(R.id.i15);
        ed17 = findViewById(R.id.i16);
        ed18 = findViewById(R.id.i17);
        ed19 = findViewById(R.id.i18);
        ed20 = findViewById(R.id.i19);
        ed21 = findViewById(R.id.i20);
        ed22 = findViewById(R.id.i21);
        ed23 = findViewById(R.id.i22);
        ed24 = findViewById(R.id.i23);
        ed25 = findViewById(R.id.i24);
        ed26 = findViewById(R.id.i25);
        ed27 = findViewById(R.id.i26);
        ed28 = findViewById(R.id.i27);
        ed29 = findViewById(R.id.i28);
        ed30 = findViewById(R.id.i29);
        ed31 = findViewById(R.id.i30);

        edt1 = findViewById(R.id.t1);
        edt2 = findViewById(R.id.t2);
        edt3 = findViewById(R.id.t3);
        edt4 = findViewById(R.id.t4);
        edt5 = findViewById(R.id.t5);
        edt6 = findViewById(R.id.t6);
        edt7 = findViewById(R.id.t7);
        edt8 = findViewById(R.id.t8);
        edt9 = findViewById(R.id.t9);
        edt10 = findViewById(R.id.t10);

        edTotal = findViewById(R.id.total);

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
        int t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,i17,i18,i19,i20,i21,i22,i23,i24,i25,i26,i27,i28,i29,
                i30,total;
        String outOf;
        String enrollment_no;
        enrollment_no = ed1.getText().toString();

        if (!enrollment_no.startsWith("FCOG")){

            Toast.makeText(this,getString(R.string.enrollmentError),Toast.LENGTH_SHORT).show();

        }
        else {

            i1 = Integer.parseInt(ed2.getText().toString().trim());
            i2 = Integer.parseInt(ed3.getText().toString().trim());
            i3 = Integer.parseInt(ed4.getText().toString().trim());
            i4 = Integer.parseInt(ed5.getText().toString().trim());
            i5 = Integer.parseInt(ed6.getText().toString().trim());
            i6 = Integer.parseInt(ed7.getText().toString().trim());
            i7 = Integer.parseInt(ed8.getText().toString().trim());
            i8 = Integer.parseInt(ed9.getText().toString().trim());
            i9 = Integer.parseInt(ed10.getText().toString().trim());
            i10 = Integer.parseInt(ed11.getText().toString().trim());
            i11 = Integer.parseInt(ed12.getText().toString().trim());
            i12 = Integer.parseInt(ed13.getText().toString().trim());
            i13 = Integer.parseInt(ed14.getText().toString().trim());
            i14 = Integer.parseInt(ed15.getText().toString().trim());
            i15 = Integer.parseInt(ed16.getText().toString().trim());
            i16 = Integer.parseInt(ed17.getText().toString().trim());
            i17 = Integer.parseInt(ed18.getText().toString().trim());
            i18 = Integer.parseInt(ed19.getText().toString().trim());
            i19 = Integer.parseInt(ed20.getText().toString().trim());
            i20 = Integer.parseInt(ed21.getText().toString().trim());
            i21 = Integer.parseInt(ed22.getText().toString().trim());
            i22 = Integer.parseInt(ed23.getText().toString().trim());
            i23 = Integer.parseInt(ed24.getText().toString().trim());
            i24 = Integer.parseInt(ed25.getText().toString().trim());
            i25 = Integer.parseInt(ed26.getText().toString().trim());
            i26 = Integer.parseInt(ed27.getText().toString().trim());
            i27 = Integer.parseInt(ed28.getText().toString().trim());
            i28 = Integer.parseInt(ed29.getText().toString().trim());
            i29 = Integer.parseInt(ed30.getText().toString().trim());
            i30 = Integer.parseInt(ed31.getText().toString().trim());

            if (i1>2 || i2>3 || i3>5 || i4>2 || i5>3 || i6>5 || i7>2 || i8>3 || i9>5 || i10>2 || i11>3 || i12>5 || i13>2 || i14>3 || i15>5 || i16>2 || i17>3 || i18>5 || i19>2 || i20>3 || i21>5 || i22>2 || i23>3 || i24>5 || i25>2 || i26>3 || i27>5 || i28>2 || i29>3 || i30>5){
                Toast.makeText(this,getString(R.string.termWork),Toast.LENGTH_SHORT).show();
            }
            else {

                t1 = i1 + i2 + i3;
                edt1.setText(String.valueOf(t1));

                t2 = i4 + i5 + i6;
                edt2.setText(String.valueOf(t2));

                t3 = i7 + i8 + i9;
                edt3.setText(String.valueOf(t3));

                t4 = i10 + i11 + i12;
                edt4.setText(String.valueOf(t4));

                t5 = i13 + i14 + i15;
                edt5.setText(String.valueOf(t5));

                t6 = i16 + i17 + i18;
                edt6.setText(String.valueOf(t6));

                t7 = i19 + i20 + i21;
                edt7.setText(String.valueOf(t7));

                t8 = i22 + i23 + i24;
                edt8.setText(String.valueOf(t8));

                t9 = i25 + i26 + i27;
                edt9.setText(String.valueOf(t9));

                t10 = i28 + i29 + i30;
                edt10.setText(String.valueOf(t10));

                outOf = getString(R.string.finalTotal);

                total = t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10;
                String Total_Term_Work_Marks = total + outOf;
                edTotal.setText(Total_Term_Work_Marks);

                studentDetails.setExp1_total(t1);
                studentDetails.setExp2_total(t2);
                studentDetails.setExp3_total(t3);
                studentDetails.setExp4_total(t4);
                studentDetails.setExp5_total(t5);
                studentDetails.setExp6_total(t6);
                studentDetails.setExp7_total(t7);
                studentDetails.setExp8_total(t8);
                studentDetails.setExp9_total(t9);
                studentDetails.setExp10_total(t10);
                studentDetails.setTotal_Term_Work_Marks(Total_Term_Work_Marks);

                reference.child(enrollment_no).child("Term Work").setValue(studentDetails);

            }
        }
    }

    public void clear(){
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
        edt1.setText("");
        edt2.setText("");
        edt3.setText("");
        edt4.setText("");
        edt5.setText("");
        edt6.setText("");
        edt7.setText("");
        edt8.setText("");
        edt9.setText("");
        edt10.setText("");
        edTotal.setText("");
        ed1.requestFocus();

    }
}
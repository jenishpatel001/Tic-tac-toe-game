package com.example.dailodemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView tx1,tx2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void time(View view) {
        TimePickerDialog t = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String msg = hourOfDay + " : " + minute ;
                tx1.setText(msg);
            }
        }, 6, 29, false);
        t.show();

    }

    public void date(View view) {
        DatePickerDialog d = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String msg = year + "/"+ month + "/" + dayOfMonth;
                tx2.setText(msg);
            }
        }, 2021, 6, 14);
        d.show();
    }

    public void prog1(View view) {
        ProgressDialog p1 = new ProgressDialog(this);
        p1.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        p1.setMessage("progress one");
        p1.show();
    }

    public void prog2(View view) {

        ProgressDialog p1 = new ProgressDialog(this);
        p1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        p1.setMessage("progress two");
        p1.show();
    }

    public void alert(View view) {
        AlertDialog.Builder a;
        a = new AlertDialog.Builder(this);
        a.setMessage("my msg");
        a.setTitle("title here");
        a.setIcon(R.drawable.aaaa);
        a.setPositiveButton("yes",null);
        a.setNegativeButton("no",null);
        a.setNeutralButton("neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "msg", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog b = a.create();
        b.show();
    }
}
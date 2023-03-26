package com.example.acd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class timePicker extends AppCompatActivity {
    TextView getTime,getDialogDate;
    Button timePickerButton,timePickerDialogButton;
    TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        //get id
        getTime= findViewById(R.id.getTime);
        getDialogDate= findViewById(R.id.getDialogTime);

        timePicker= findViewById(R.id.timePicker);

        timePickerButton= findViewById(R.id.timePickerButton);
        timePickerDialogButton= findViewById(R.id.timePickerDialogButton);

        timePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = "";
                date += timePicker.getCurrentHour()+":";
                date += timePicker.getCurrentMinute();
                getTime.setText(date);
            }
        });
        TimePicker timePicker = new TimePicker(this);
        TimePickerDialog timePickerDialog = new TimePickerDialog(com.example.acd.timePicker.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                getDialogDate.setText(i+":"+i1);
            }
        },timePicker.getCurrentHour(),timePicker.getCurrentMinute(),true);

        timePickerDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });


    }
}
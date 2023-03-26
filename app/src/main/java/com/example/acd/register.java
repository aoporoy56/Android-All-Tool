package com.example.acd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {
    String[] courseList={"Java","Web Design","Web Development","Networking","Graphics Design"};
    EditText inputName,inputEmail,inputNumber,inputPassword,inputConfirmPassword;
    Button register,reset,getDate;
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView dateShow;
    Spinner course;
    CheckBox hobbiesGardening,hobbiesTouring,hobbiesWriting,hobbiesTyping,hobbiesMore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //edit text
        inputName=findViewById(R.id.inputName);
        inputEmail=findViewById(R.id.inputEmail);
        inputNumber=findViewById(R.id.inputNumber);
        inputPassword=findViewById(R.id.inputPassword);
        inputConfirmPassword=findViewById(R.id.inputConfirmPassword);

        //TextView
        dateShow=findViewById(R.id.dateShow);

        //Radio button
        radioGroup=findViewById(R.id.radioGroup);

        //checkBox
        hobbiesGardening = findViewById(R.id.hobbiesGardening);
        hobbiesTouring = findViewById(R.id.hobbiesTouring);
        hobbiesWriting = findViewById(R.id.hobbiesWriting);
        hobbiesTyping = findViewById(R.id.hobbiesTyping);
        hobbiesMore = findViewById(R.id.hobbiesMore);

        //button
        register=findViewById(R.id.register);
        reset=findViewById(R.id.reset);
        getDate=findViewById(R.id.getDate);

        //spinner
        course=findViewById(R.id.course);
        ArrayAdapter arrayAdapter = new ArrayAdapter(com.example.acd.register.this, android.R.layout.simple_list_item_1,courseList);
        course.setAdapter(arrayAdapter);

        //current date get
        DatePicker datePicker = new DatePicker(this);
        int date = datePicker.getDayOfMonth();
        int month= (datePicker.getMonth())+1;
        int year = datePicker.getYear();
        getDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(com.example.acd.register.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        dateShow.setText(i+"/"+(i1+1)+"/"+i2);
                    }
                },date,month,year);
                datePickerDialog.show();
            }
        });

        //alertDialog
        AlertDialog.Builder alertBox= new AlertDialog.Builder(com.example.acd.register.this);
        alertBox.setCancelable(false);
        alertBox.setIcon(R.drawable.ic_failed);
        alertBox.setTitle("Confirm");
        alertBox.setMessage("All Input Is Correct?");
        alertBox.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        alertBox.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int a = radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(a);
                String hobbies="";
                if (hobbiesGardening.isChecked()){
                    hobbies="Gardening";
                }
                if (hobbiesTouring.isChecked()){
                    hobbies=hobbies+"\nTouring";
                }
                if (hobbiesWriting.isChecked()){
                    hobbies=hobbies+"\nWriting";
                }
                if (hobbiesTyping.isChecked()){
                    hobbies=hobbies+"\nTyping";
                }
                if (hobbiesMore.isChecked()){
                    hobbies=hobbies+"\nMore";
                }

                Intent intent = new Intent(com.example.acd.register.this,deshboard.class);
                intent.putExtra("sendName",inputName.getText().toString());
                intent.putExtra("sendGender",radioButton.getText().toString());
                intent.putExtra("sendDateOfBirth",dateShow.getText().toString());
                intent.putExtra("sendCourse",course.getSelectedItem().toString());
                intent.putExtra("sendEmail",inputEmail.getText().toString());
                intent.putExtra("sendNumber",inputNumber.getText().toString());
                intent.putExtra("sendPassword",inputPassword.getText().toString());
                intent.putExtra("sendHobbies",hobbies);
                Toast.makeText(com.example.acd.register.this,inputName.getText().toString(),Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
        alertBox.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog dialog = alertBox.create();
                dialog.show();


            }
        });











    }
}
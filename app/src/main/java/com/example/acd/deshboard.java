package com.example.acd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class deshboard extends AppCompatActivity {
    TextView outputName,outputGender,outputDateOfBirth,outputCourse,outputEmail,outputNumber,outputPassword,outputHobbies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deshboard);
        Bundle bundle = getIntent().getExtras();
        outputName=findViewById(R.id.outputName);
        outputGender=findViewById(R.id.outputGender);
        outputDateOfBirth=findViewById(R.id.outputDateOfBirth);
        outputCourse=findViewById(R.id.outputCourse);
        outputEmail=findViewById(R.id.outputEmail);
        outputNumber=findViewById(R.id.outputNumber);
        outputPassword=findViewById(R.id.outputPassword);
        outputHobbies=findViewById(R.id.outputHobbies);
        if (bundle!=null)
        {
            outputName.setText(bundle.getString("sendName"));
            outputGender.setText(bundle.getString("sendGender"));
            outputDateOfBirth.setText(bundle.getString("sendDateOfBirth"));
            outputCourse.setText(bundle.getString("sendCourse"));
            outputEmail.setText(bundle.getString("sendEmail"));
            outputNumber.setText(bundle.getString("sendNumber"));
            outputName.setText(bundle.getString("sendName"));
            outputPassword.setText(bundle.getString("sendPassword"));
            outputHobbies.setText(bundle.getString("sendHobbies"));
        }
    }
}
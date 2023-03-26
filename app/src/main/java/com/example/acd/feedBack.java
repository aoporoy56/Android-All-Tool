package com.example.acd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class feedBack extends AppCompatActivity {
    EditText inputSubject,inputMassage;
    Button feedBack,reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        //edittext
        inputSubject = findViewById(R.id.inputSubject);
        inputMassage = findViewById(R.id.inputMassage);

        //button
        feedBack = findViewById(R.id.feedBack);
        reset = findViewById(R.id.reset);
        feedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"aopo56@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,inputSubject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,inputMassage.getText().toString());
                startActivity(Intent.createChooser(intent,"Select Email"));
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputSubject.setText("");
                inputMassage.setText("");
            }
        });
    }
}
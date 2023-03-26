package com.example.acd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class switchButton extends AppCompatActivity {
    Switch switchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_button);

        //id get
        switchButton = findViewById(R.id.switchButton);
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b==true)
                {
                    Toast.makeText(com.example.acd.switchButton.this,"It is ON",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(com.example.acd.switchButton.this,"It is OFF",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
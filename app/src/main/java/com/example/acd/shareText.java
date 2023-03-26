package com.example.acd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class shareText extends AppCompatActivity {
    EditText inputText;
    Button shareText,shareTextByMail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_text);
        inputText = findViewById(R.id.inputText);
        shareText = findViewById(R.id.shareText);
        shareTextByMail = findViewById(R.id.shareTextByMail);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,"Hello World");
        shareText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra(Intent.EXTRA_TEXT,inputText.getText().toString());
                startActivity(Intent.createChooser(intent,"Shere this with thoose"));
            }
        });

        Intent mailIntent = new Intent(Intent.ACTION_SEND);
        mailIntent.setType("text/email");
        mailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{"aopo56@gmail.com","aopo56@gmail.com"});
        mailIntent.putExtra(Intent.EXTRA_SUBJECT,"This is subject");

        shareTextByMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mailIntent.putExtra(Intent.EXTRA_TEXT,inputText.getText().toString());
                startActivity(Intent.createChooser(mailIntent,"Share this"));
            }
        });
    }
}
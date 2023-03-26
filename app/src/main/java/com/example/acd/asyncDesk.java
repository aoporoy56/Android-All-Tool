package com.example.acd;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class asyncDesk extends AppCompatActivity {
    TextView textView;
    String urls = "https://unflavoured-furnace.000webhostapp.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_desk);

        //get id
        textView = findViewById(R.id.textView);

        new getData().execute();
    }
    class getData extends AsyncTask<String, String, String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(asyncDesk.this,"Loading",Toast.LENGTH_LONG);
        }

        @Override
        protected void onPostExecute(String s) {
            textView.setText(s);
            Toast.makeText(asyncDesk.this,"Loading",Toast.LENGTH_LONG);
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            Toast.makeText(asyncDesk.this,values.toString(),Toast.LENGTH_LONG);
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(String... strings) {
            HttpsURLConnection http = null;
            BufferedReader reader = null;
            try {
                URL url = new URL(urls);
                http= (HttpsURLConnection) url.openConnection();
                reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
                String file = "";
                StringBuffer sb = new StringBuffer();
                while((file= reader.readLine())!=null)
                {
                    sb.append(file+"\n");
                }
                return sb.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                http.disconnect();
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
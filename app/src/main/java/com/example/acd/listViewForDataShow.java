package com.example.acd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.net.URL;

public class listViewForDataShow extends AppCompatActivity {
    ListView listView;
    String link= "https://unflavoured-furnace.000webhostapp.com/index.php";
    String[] list = {"Oranges","Grapefruits","Mandarins ","Limes","Apricots","Bananas","Mangoes","Strawberries","Raspberries","Blueberries","Kiwifruit"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_for_data_show);
        listView = findViewById(R.id.listView);

        //online connect start
        StringRequest stringRequest = new StringRequest(Request.Method.POST, link, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //online connect end
//
//        listViewAdapter adapter = new listViewAdapter(listViewForDataShow.this,);
//        listView.setAdapter(adapter);
    }
}
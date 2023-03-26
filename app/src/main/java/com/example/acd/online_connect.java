package com.example.acd;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class online_connect extends AppCompatActivity {
    EditText inputName,inputRoll,inputReg;
    Button register;
    String url = "https://unflavoured-furnace.000webhostapp.com/insert-query.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_connect);

        //edittext
        inputName = findViewById(R.id.inputName);
        inputRoll = findViewById(R.id.inputRoll);
        inputReg = findViewById(R.id.inputReg);

        //button
        register=findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(online_connect.this,response,Toast.LENGTH_LONG).show();
                        inputName.setText("");
                        inputRoll.setText("");
                        inputReg.setText("");
                        inputName.requestFocus();
                        Intent viewList = new Intent(online_connect.this,asyncDesk.class);
                        startActivity(viewList);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(online_connect.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String,String>();
                        params.put("input_name",inputName.getText().toString());
                        params.put("input_roll",inputRoll.getText().toString());
                        params.put("input_reg",inputReg.getText().toString());
                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(online_connect.this);
                requestQueue.add(stringRequest);
            }
        });

    }
}
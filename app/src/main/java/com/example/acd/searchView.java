package com.example.acd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class searchView extends AppCompatActivity {
    SearchView searchView;
    Button button,clearList;
    EditText addName;
    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter, arrayAdapter2;
    SharedPreferences sharedPreferences;
    Set<String> valuesLIst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
        searchView=findViewById(R.id.searchView);
        listView=findViewById(R.id.listView);
        searchView=findViewById(R.id.searchView);
        button=findViewById(R.id.button);
        addName=findViewById(R.id.addName);
        clearList=findViewById(R.id.clearList);

        sharedPreferences = getApplicationContext().getSharedPreferences("acdData",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();





//        if(!sharedPreferences.getAll().containsKey("listItem")){
//            editor.putStringSet("listItem",new HashSet<>());
//            editor.commit();
//            valuesLIst = sharedPreferences.getStringSet("listItem",new HashSet<>());
//            Toast.makeText(getApplicationContext(), "na", Toast.LENGTH_SHORT).show();
//
//
//        }else{
//            test(sharedPreferences.getStringSet("listItem",new HashSet<>()));
//            Toast.makeText(getApplicationContext(), "ache", Toast.LENGTH_SHORT).show();
//
//        }
        valuesLIst = sharedPreferences.getStringSet("listItem",new HashSet<>());
        test(sharedPreferences.getStringSet("listItem",new HashSet<>()));
//        Toast.makeText(getApplicationContext(), sharedPreferences.getStringSet("listItem",new HashSet<>()).size(), Toast.LENGTH_SHORT).show();

        //add Item button work
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!addName.getText().toString().isEmpty()){

                    valuesLIst.add(addName.getText().toString());
                    editor.putStringSet("listItem",valuesLIst);
                    editor.commit();
                    test(sharedPreferences.getStringSet("listItem",new HashSet<>()));
                    addName.setText("");
                }else{
                    Toast.makeText(getApplicationContext(), "Enter Item Name", Toast.LENGTH_SHORT).show();
                }
            }
        });
        clearList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.remove("listItem");
                editor.commit();
                valuesLIst = sharedPreferences.getStringSet("listItem",new HashSet<>());
                test(sharedPreferences.getStringSet("listItem",new HashSet<>()));
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (s==""){
    //                    test(sharedPreferences.getStringSet("listItem",new HashSet<>()));
                    Toast.makeText(getApplicationContext(), "nal", Toast.LENGTH_SHORT).show();
                }else {
                    arrayAdapter.getFilter().filter(s);
                    Toast.makeText(getApplicationContext(), "Fillter", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }
    void test(Set<String> b){
        arrayList = new ArrayList<>();
        arrayList.addAll(b);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }
}
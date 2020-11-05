package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Date1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner sp1 =null;
    private Spinner sp2 =null;
    public static String month="1月";
    public static String date="1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date1);

        sp1=(Spinner)findViewById(R.id.spinner1);
        sp2=(Spinner)findViewById(R.id.spinner2);

//        String[] arr={"1","2","3","4","5","6","7","8","9","10","11","12"};
  //      ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);
    //    sp2.setAdapter(adapter);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                month=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp2.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String content = parent.getItemAtPosition(position).toString();
        date=content;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void jumpAdd(View v){
        Intent intent = new Intent();
        intent.setClass(Date1.this, Add.class);
        startActivity(intent);

    }
    public void jumpMain(View v){
        Intent intent = new Intent();
        intent.setClass(Date1.this, MainActivity.class);
        startActivity(intent);

    }
}
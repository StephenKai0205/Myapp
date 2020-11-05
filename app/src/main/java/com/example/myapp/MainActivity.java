package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void jumpAdd(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, Add.class);
        startActivity(intent);

    }
    public void jumpDate(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, Date.class);
        startActivity(intent);

    }
    public void jumpDate1(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, Date1.class);
        startActivity(intent);

    }

}
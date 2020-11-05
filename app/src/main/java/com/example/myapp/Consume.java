package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapp.database.DBManager;
import com.example.myapp.database.Item;

import java.util.List;

import static com.example.myapp.Date.date;
import static com.example.myapp.Date.month;

public class Consume extends AppCompatActivity {
    TextView out1;
    TextView out2;
    TextView out3;
    TextView out4;
    TextView out5;
    TextView out6;
    EditText edit;
    DBManager dbManager;
    double lm;
    double sm;
    double em;
    double om;
private double sum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.consume);
        dbManager=new DBManager(this);
        out1 =(TextView)findViewById(R.id.date);
        out1.setText(month+date);
        List<Item> items = dbManager.listAllDate(month + date);
        Item temp=items.get(0);
        out2 =(TextView)findViewById(R.id.life);
        sum+=Double.parseDouble(temp.getMoney());
        out2.setText(temp.getType()+":"+temp.getMoney());
        temp=items.get(1);
        sum+=Double.parseDouble(temp.getMoney());
        out3 =(TextView)findViewById(R.id.study);
        out3.setText(temp.getType()+":"+temp.getMoney());
        temp=items.get(2);
        sum+=Double.parseDouble(temp.getMoney());
        out4 =(TextView)findViewById(R.id.entertainment);
        out4.setText(temp.getType()+":"+temp.getMoney());
        temp=items.get(3);
        sum+=Double.parseDouble(temp.getMoney());
        out5 =(TextView)findViewById(R.id.other);
        out5.setText(temp.getType()+":"+temp.getMoney());

        out6 = (TextView) findViewById(R.id.total);
        out6.setText("总计："+sum);
    }
   public void setItem(View v){
       out1 = (TextView) findViewById(R.id.total);
       Double m = Double.parseDouble((out1.getText().toString()).split(":")[1]);
       out1.setText("总计："+sum);
    }

    public void jumpDate(View v){
        Intent intent = new Intent();
        intent.setClass(Consume.this, Date.class);
        startActivity(intent);

    }
    public void jumpShow(View v){
        Intent intent = new Intent();
        intent.setClass(Consume.this, Show.class);
        startActivity(intent);

    }

}

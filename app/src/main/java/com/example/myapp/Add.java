package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.database.DBHelper;
import com.example.myapp.database.DBManager;
import com.example.myapp.database.Item;

import static com.example.myapp.Date.date;
import static com.example.myapp.Date.month;

public class Add extends AppCompatActivity {
    TextView out;
    EditText edit;
     DBManager dbManager;
    int n=0;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        out =(TextView)findViewById(R.id.date);
        out.setText(month+date);
        dbManager=new DBManager(this);
        dbHelper = new DBHelper( this, "consume.db" ,null,1);
        AddItem();

    }

            public void AddItem() {

            Spinner ps=(Spinner)findViewById(R.id.spinner);
            ps.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String content = parent.getItemAtPosition(position).toString();
                    switch(content){
                        case "生活消费":
                            n=1;
                            break;
                        case "学习消费":
                            n=2;
                            break;
                        default:
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

           }

            public void jumpConsume(View v) {
                Intent intent = new Intent();
                intent.setClass(Add.this, Consume.class);
                startActivity(intent);

            }
    public void jumpMain(View v) {
        Intent intent = new Intent();
        intent.setClass(Add.this, MainActivity.class);
        startActivity(intent);

    }
    public void Add(View v){
        EditText editText1 = findViewById(R.id.money);
        String money = String.valueOf(editText1.getText());
        EditText editText2 = findViewById(R.id.mark);
        String mark = String.valueOf(editText2.getText());
        Item it=new Item();
        it.setMoney(money);
        it.setDate(Date1.month+Date1.date);
        it.setMark(mark);
        if(n==1){
            it.setType("life");
        }else if(n==2){
            it.setType("study");
        }else if(n==3){
            it.setType("entertainment");
        }else if(n==4){
            it.setType("other");
        }
        dbManager.add(it);
        Toast.makeText(Add.this,"添加成功！",Toast.LENGTH_SHORT).show();

    }

        }
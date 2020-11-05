package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.myapp.database.DBManager;
import com.example.myapp.database.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.myapp.Date.date;
import static com.example.myapp.Date.month;

public class Show extends ListActivity {
    Handler handler;
    private ArrayList<HashMap<String, String>> listItems; // 存放文字、图片信息
    private SimpleAdapter listItemAdapter; // 适配器
    private int msgWhat = 7;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.show);
        dbManager=new DBManager(this);
        initListView();
        this.setListAdapter(listItemAdapter);

    }
    public void initListView() {
        listItems = new ArrayList<HashMap<String, String>>();
        List<Item> items = dbManager.listAll(month + date);
//
        for (int i = 0; i < 10&&i<items.size(); i++) {
              Item temp=items.get(0);
//            out2 =(TextView)findViewById(R.id.life);
//            sum+=Double.parseDouble(temp.getMoney());
//            out2.setText(temp.getType()+":"+temp.getMoney());
//            temp=items.get(1);
//            sum+=Double.parseDouble(temp.getMoney());
//            out3 =(TextView)findViewById(R.id.study);
//            out3.setText(temp.getType()+":"+temp.getMoney());
//            temp=items.get(2);
//            sum+=Double.parseDouble(temp.getMoney());
//            out4 =(TextView)findViewById(R.id.entertainment);
//            out4.setText(temp.getType()+":"+temp.getMoney());
//            temp=items.get(3);
//            sum+=Double.parseDouble(temp.getMoney());
//            out5 =(TextView)findViewById(R.id.other);
//            out5.setText(temp.getType()+":"+temp.getMoney());
            HashMap<String, String> map = new HashMap<String, String>();
            String str1=items.get(i).getType();
            String str2=items.get(i).getMoney();
            String str3=items.get(i).getMark();
            map.put("id", "" + i);
            map.put("type", "" + str1);
            map.put("money", "" +str2);// 标题文字
            map.put("mark", "" + str3); // 详情描述
            listItems.add(map);
        }
        // 生成适配器的Item和动态数组对应的元素
        listItemAdapter = new SimpleAdapter(this, listItems, // listItems数据源
                R.layout.show,    // ListItem的XML布局实现
                new String[] { "id", "type","money","mark" },
                new int[] { R.id.id, R.id.type,R.id.money,R.id.mark }
        );
    }


}
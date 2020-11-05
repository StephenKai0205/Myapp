package com.example.myapp.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "mydb.db";
    public static final String TB_NAME = "consume";
//    private Context mContext;
//
//    public static final String CREATE_TABLE = "create table consume ("
//            //primary key设置为主键，autoincrement关键字表示该列是自增长的
//            + "area_id text primary key autoincrement,"
//            + "date text,"
//            + "life real,"
//            + "study real,"
//            + "entertainment real,"
//            + "other real,"
//            + "mark text)";


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                    int version) {
        super(context, name, factory, version);
    }
    public DBHelper(Context context) {
        super(context,DB_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TB_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,TYPE TEXT,MONEY TEXT,MARK TEXT,DATE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }

}
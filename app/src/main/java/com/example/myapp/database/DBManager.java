package com.example.myapp.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private DBHelper dbHelper;
    private String TBNAME;

    public DBManager(Context context) {
        dbHelper = new DBHelper(context);
        TBNAME = DBHelper.TB_NAME;
    }

    public void add(Item item) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TYPE", item.getType());
        values.put("MONEY", item.getMoney());
        values.put("MARK", item.getMark());
        values.put("DATE", item.getDate());
        db.insert(TBNAME, null, values);
        db.close();
    }

//    public void addAll(List<Item> list){
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        for (Item item : list) {
//            ContentValues values = new ContentValues();
//            values.put("curname", item.getCurName());
//            values.put("currate", item.getCurRate());
//            db.insert(TBNAME, null, values);
//        }
//        db.close();
//    }

    public void deleteAll() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME, null, null);
        db.close();
    }

    public void delete(int id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME, "ID=?", new String[]{String.valueOf(id)});
        db.close();
    }

    //    public void update(Item item){
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("curname", item.getCurName());
//        values.put("currate", item.getCurRate());
//        db.update(TBNAME, values, "ID=?", new String[]{String.valueOf(item.getId())});
//        db.close();
//    }
    public List<Item> listAll(String Date) {
        List<Item> rateList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME, null, "date=?", new String[]{Date}, null, null, null);
        if (cursor != null) {
            rateList = new ArrayList<Item>();
            while (cursor.moveToNext()) {
                Item item = new Item();
                //               item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                item.setType(cursor.getString(cursor.getColumnIndex("TYPE")));
                item.setMoney(cursor.getString(cursor.getColumnIndex("MONEY")));
                item.setMark(cursor.getString(cursor.getColumnIndex("MARK")));

                rateList.add(item);
            }
            cursor.close();
        }
        db.close();
        return rateList;

    }

    public List<Item> listAllDate(String Date) {
        List<Item> rateList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        HashMap<String, String> hm = new HashMap<>();
        Cursor cursor = db.query(TBNAME, new String[]{"TYPE","MONEY"}, "DATE=?", new String[]{Date}, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                cursor.getColumnIndex("TYPE");
                String Type = cursor.getString(cursor.getColumnIndex("TYPE"));
                String money = cursor.getString(cursor.getColumnIndex("MONEY"));
                if (!hm.keySet().contains(Type))
                    hm.put(Type, money);
                else
                    hm.put(Type, String.valueOf(Double.parseDouble(hm.get(Type)) + Double.parseDouble(money)));
            }
            cursor.close();
        }
        if (!hm.keySet().contains("life"))
            hm.put("life", "0");
        if (!hm.keySet().contains("study"))
            hm.put("study", "0");
        if (!hm.keySet().contains("entertainment"))
            hm.put("entertainment", "0");
        if (!hm.keySet().contains("other"))
            hm.put("other", "0");
        for (String s : hm.keySet()) {
            Item item = new Item();
            item.setMoney(hm.get(s));
            item.setType(s);
            rateList.add(item);
        }
        db.close();
        return rateList;

    }

//    public RateItem findById(int id){
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        Cursor cursor = db.query(TBNAME, null, "ID=?", new String[]{String.valueOf(id)}, null, null, null);
//        RateItem rateItem = null;
//        if(cursor!=null && cursor.moveToFirst()){
//            rateItem = new RateItem();
//            rateItem.setId(cursor.getInt(cursor.getColumnIndex("ID")));
//            rateItem.setCurName(cursor.getString(cursor.getColumnIndex("CURNAME")));
//            rateItem.setCurRate(cursor.getString(cursor.getColumnIndex("CURRATE")));
//            cursor.close();
//        }
//        db.close();
//        return rateItem;
//    }
}

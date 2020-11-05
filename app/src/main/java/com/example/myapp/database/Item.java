package com.example.myapp.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Item {
    private int id;
    private String type;
    private String money;
    private String mark;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Item() {
        super();
        type = "";
        money = "";
        mark = "";
    }
    public Item(String life, String study,String entertainment,String other) {
        super();
        this.type = type;
        this.money = money;
        this.mark = mark;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
package com.example.admin.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 2017/2/16.
 */

public class MyOpenHelper extends SQLiteOpenHelper{
    public MyOpenHelper(Context context) {
        super(context, "people.db", null, 1);
    }




    //数据库创建时，此方法会调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table person(_id integer primary key autoincrement,name char(10),salary char(20), phone integer(20))");
    }
    //数据库升级时，此方法会调用
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("The Database UPDATE");
    }


}

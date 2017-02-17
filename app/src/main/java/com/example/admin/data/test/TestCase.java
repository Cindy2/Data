package com.example.admin.data.test;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.example.admin.data.MyOpenHelper;

/**
 * Created by Admin on 2017/2/17.
 */

public class TestCase extends AndroidTestCase {
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;
    //测试框架初始化完毕之后，在测试方法执行之前，此方法调用
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        myOpenHelper = new MyOpenHelper(getContext());
        sqLiteDatabase = myOpenHelper.getWritableDatabase();
    }
    //测试方法执行完毕之后，此方法调用
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        sqLiteDatabase.close();
    }
    public void insertApi(){
        for (int i=0;i<50;i++){
            ContentValues contentValues = new ContentValues();
            contentValues.put("name","陈"+i);
            contentValues.put("phone","159"+i);
            contentValues.put("salary","160"+i);
            sqLiteDatabase.insert("person",null,contentValues);
        }
    }
}

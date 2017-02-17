package com.example.admin.data;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest extends AndroidTestCase{

    private MyOpenHelper mMyOpenHelper;
    private SQLiteDatabase db;

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        int result = Utils.add(3,5);
        //断言：用来检测实际值与期望值是否一致
        assertEquals(8,result);
        Utils.chuyi(2,1);

        mMyOpenHelper = new MyOpenHelper(getContext());
        //如果数据库不存在，先创建数据库，再获取可读可写的数据库对象，如果数据库存在，就直接打开
        SQLiteDatabase db = mMyOpenHelper.getWritableDatabase();
    }
    //测试框架初始化完毕之后，在测试方法执行之前，此方法调用
    @Override
    protected void setUp() throws Exception {

        mMyOpenHelper = new MyOpenHelper(getContext());
        db = mMyOpenHelper.getWritableDatabase();
        super.setUp();
    }
    //测试方法执行完毕之后，此方法调用
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        db.close();
    }
//    public void insert(){
//        db.execSQL("insert into person(name,salary,phone)values(?,?,?)",new Object[]{"Cindy",1400,"13400"});
//    }
//    public void insertApi(){
//        //把要插入的数据全部封装至ContentValues对象
//        ContentValues values = new ContentValues();
//        values.put("name", "Cindy");
//        values.put("phone", "15999");
//        values.put("salary", 16000);
//        db.insert("person", null, values);
//    }
    public void insertApi(){
        //把要插入的数据全部封装至ContentValues对象
       for (int i =0;i<50;i++){
        ContentValues values = new ContentValues();
        values.put("name", "Cindy"+i);
        values.put("phone", "159"+i+i);
        values.put("salary", "160"+i+i);
        db.insert("person", null, values);}
    }
//    public void deleteApi(){
//        int i = db.delete("person", "name = ? and _id = ?", new String[]{"小志的儿子", "3"});
//        System.out.println(i);
//    }
//
//    public void updateApi(){
//        ContentValues values = new ContentValues();
//        values.put("salary", 26000);
//        int i = db.update("person", values, "name = ?", new String[]{"游天龙"});
//        System.out.println(i);
//    }
//
//    public void selectApi(){
//        Cursor cursor = db.query("person", null, null, null, null, null, null, null);
//        while(cursor.moveToNext()){
//            String name = cursor.getString(cursor.getColumnIndex("name"));
//            String phone = cursor.getString(cursor.getColumnIndex("phone"));
//            String salary = cursor.getString(cursor.getColumnIndex("salary"));
//            System.out.println(name + ";" + phone + ";" + salary);
//        }
//    }
//    public  void transaction(){
//        try {
//            db.beginTransaction();
//            ContentValues values = new ContentValues();
//            values.put("salary",12000);
//            db.update("person",values,"name = ?",new String[]{"Cindy"});
//            values.clear();
//            values.put("salary",4250);
//            db.update("person",values,"name = ?",new String[]{"Cindy's son"});
//
//            int i = 3/0;
//            //设置  事务执行成功
//            db.setTransactionSuccessful();}
//
//        catch (Exception e) {
//        			e.printStackTrace();
//        		}
//        	finally {
//            //关闭事务，同时提交
//                     db.endTransaction();
//    }
//    }
}

package com.example.admin.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.data.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Person>  mPersonList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPersonList = new ArrayList<Person>();
        //把数据库的数据查询出来
        MyOpenHelper myOpenHelper = new MyOpenHelper(this);
        SQLiteDatabase sqLiteDatabase = myOpenHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query("person",null,null,null,null,null,null,null);
        while(cursor.moveToNext()){
            String _id = cursor.getString(0);
            String name = cursor.getString(1);
            String salary = cursor.getString(2);
            String phone = cursor.getString(3);

            Person person = new Person(_id,name,salary,phone);
            mPersonList.add(person);
        }
        ListView listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(new MyAdapter());
//        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear);
//        //把数据显示至屏幕
//        for (Person person : mPersonList){
//            TextView textView = new TextView(this);
//            textView.setText(person.toString());
//            textView.setTextSize(18);
//            linearLayout.addView(textView);
//        }
    }
//extends BaseAdapter
    private class MyAdapter extends BaseAdapter {
    //系统调用，用来获知集合中有多少条元素
        @Override
        public int getCount() {
            return mPersonList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //由系统调用，获取一个View对象，作为ListView的条目
            //position:本次getView方法调用所返回的View对象，在listView中是处于第几个条目，那么position的值就是多少
            Person person = mPersonList.get(position);
            System.out.println("gitView:"+position+";"+convertView);
            View view = null;
            //判断条目是否有缓存
            if (convertView == null){
                view = View.inflate(MainActivity.this,R.layout.item_listview,null);
            }else{
                view = convertView;
            }
            TextView textView1 = (TextView) findViewById(R.id.tv_name);
            textView1.setText(person.getName());
            TextView textView2 = (TextView) findViewById(R.id.tv_phone);
            textView2.setText(person.getPhone());
            TextView textView3 = (TextView) findViewById(R.id.tv_salary);
            textView3.setText(person.getSalary());
            return view;
        }
    }
}

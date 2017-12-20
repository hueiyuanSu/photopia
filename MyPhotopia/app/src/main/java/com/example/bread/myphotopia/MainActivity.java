package com.example.bread.myphotopia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /** Called when the activity is first created. */
    static final String db_name="Database1";    // 資料庫名稱
    static final String tb_name="photo";        // 資料表名稱
    SQLiteDatabase db;    //資料庫

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imageButton1 = (ImageButton)findViewById(R.id.imageButton1);

        imageButton1.setOnClickListener(new ImageButton.OnClickListener(){

            public void onClick(View view) {
                Intent myIntent = new Intent();
                myIntent.setClass(MainActivity.this, SearchActivity.class);
                startActivity(myIntent);

            }
        });
        db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE, null);
        Cursor c=db.rawQuery("SELECT * FROM "+tb_name, null);
        if (c.getCount()>0){    // 若有資料
            String str="總共有 "+c.getCount()+"筆資料\n";
            str+="-----\n";

            c.moveToFirst();    // 移到第 1 筆資料
            do{        // 逐筆讀出資料
                str+="id:"+c.getString(0)+"\n";
                str+="time:"+c.getString(1)+"\n";
                str+="iso:"+c.getString(2)+"\n";
                str+="aperture:"+c.getString(3)+"\n";
                str+="location:"+c.getString(4)+"\n";
                str+="shutter:"+c.getString(5)+"\n";
                str+="season:"+c.getString(6)+"\n";
                str+="-----\n";
            } while(c.moveToNext());    // 有一下筆就繼續迴圈

        }

        db.close();        // 關閉資料庫
    }

}
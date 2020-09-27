package com.example.mad_059.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Module extends SQLiteOpenHelper {

    public Module( Context context) {
        super(context, "Module.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Module(MID INTEGER primary key autoincrement,mName TEXT,mCode TEXT,RegNo TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Module");

    }

    //insert module data
    public Boolean insertModule(String mName,String mCode,String RegNo)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mName", mName);
        contentValues.put("mCode", mCode);
        contentValues.put("RegNo", RegNo);


        long result=DB.insert("Module", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
}

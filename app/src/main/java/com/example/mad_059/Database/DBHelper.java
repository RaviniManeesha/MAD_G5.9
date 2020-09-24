package com.example.mad_059.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "Student.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Student(ID INTEGER primary key autoincrement, RegNo TEXT , Pwd TEXT,StName TEXT,Phone TEXT ,EMail EMAIL ,Date DATE )");
        DB.execSQL("create Table Module (RegNo primary key ,mName TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Student");
        DB.execSQL("drop Table if exists Module");
    }

    //insert data method
    public Boolean insertData(String RegNo, String Pwd,String Name,String Phone,String Email,String Date)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("RegNo", RegNo);
        contentValues.put("Pwd", Pwd);
        contentValues.put("StName", Name);
        contentValues.put("Phone", Phone);
        contentValues.put("Email", Email);
        contentValues.put("Date", Date);

        long result=DB.insert("Student", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    //retrive data method
    public Cursor getData ()
    {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Student",null);
        return cursor;


    }

    //update data method
    public Boolean UpdateData(Integer ID,String RegNo, String Name,String Phone,String Email,String Date) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("RegNo", RegNo);
        contentValues.put("StName", Name);
        contentValues.put("Phone", Phone);
        contentValues.put("Email", Email);
        contentValues.put("Date", Date);

        Cursor cursor = DB.rawQuery("Select * from Student where ID = ?", new String[]{String.valueOf(ID)});
        if (cursor.getCount() > 0) {
            long result = DB.update("Student", contentValues, "ID=?", new String[]{String.valueOf(ID)});
                if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }}


    //insert module data method
    public Boolean insertmData(String RegNo, String mName)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("RegNo", RegNo);
        contentValues.put("mName", mName);
       ;

        long result=DB.insert("Module", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }


}


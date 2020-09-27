package com.example.mad_059.Database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "Student.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Student(ID INTEGER primary key autoincrement,RegNo TEXT, Pwd TEXT, StName TEXT,Phone TEXT,Email EMAIL,Date DATE)");
        DB.execSQL("create Table Module(MID INTEGER primary key autoincrement,mName TEXT,mCode TEXT,RegNo TEXT)");
        DB.execSQL("create Table Submission(SID INTEGER primary key autoincrement,sName TEXT,rDay TEXT,rTime TEXT,Note TEXT,mCode TEXT,RegNo TEXT)");

}

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Student");
        DB.execSQL("drop Table if exists Module");
        DB.execSQL("drop Table if exists Submission");
    }



    //insert data
    public Boolean insertUser(String RegNo,String Pwd,String Name,String Phone,String Email,String Date)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("RegNo", RegNo);
        contentValues.put("Pwd", Pwd);
        contentValues.put("StName", Name);
        contentValues.put("Phone", Phone);
        contentValues.put("Email", Email);
        contentValues.put("Date",Date);

        long result=DB.insert("Student", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
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

    //insert submission data
    public Boolean insertSub(String sName,String rDay,String rTime,String Note,String mCode, String RegNo)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sName", sName);
        contentValues.put("rDay", rDay);
        contentValues.put("rTime", rTime);
        contentValues.put("Note", Note);
        contentValues.put("mCode", mCode);
        contentValues.put("RegNo", RegNo);


        long result=DB.insert("Submission", null, contentValues);
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
        Cursor cursor = db.rawQuery("select * from Student where RegNo = 'IT19083742' ",null);
        return cursor;
    }
    //retrive module data method
    public Cursor getmData ()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Module Where RegNo = 'IT19083742'",null);
        return cursor;
    }

    //retrive submission data method
    public Cursor getsData ()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Submission Where RegNo = 'IT19083742'",null);
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

    //update data method
    public Boolean UpdateUserPwd(Integer ID,String Pwd) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Pwd", Pwd);

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
    //updateSubmission method
    public Boolean UpdateSub(Integer ID,String Name, String Day,String Time,String Note) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sName", Name);
        contentValues.put("rDay", Day);
        contentValues.put("rTime", Time);
        contentValues.put("Note",Note);

        Cursor cursor = DB.rawQuery("Select * from Submission where SID = ?", new String[]{String.valueOf(ID)});
        if (cursor.getCount() > 0) {
            long result = DB.update("Submission", contentValues, "SID=?", new String[]{String.valueOf(ID)});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }}

        //delete submission
        public Boolean deleteSub(Integer ID)
        {
            SQLiteDatabase DB = this.getWritableDatabase();
            Cursor cursor = DB.rawQuery("Select * from Submission where SID = ?", new String[]{String.valueOf(ID)});
            if (cursor.getCount() > 0) {
                long result = DB.delete("Submission", "SID=?", new String[]{String.valueOf(ID)});
                if (result == -1) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }

        }


}


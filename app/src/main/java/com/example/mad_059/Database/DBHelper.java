package com.example.mad_059.Database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    //create database
    public DBHelper(Context context) {
        super(context, "Student.db", null, 1);
    }



    //create tables
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Student(ID INTEGER primary key autoincrement,RegNo TEXT, Pwd TEXT, StName TEXT,Phone TEXT,Email EMAIL,Date DATE)");
        DB.execSQL("create Table Submission(SID INTEGER primary key autoincrement,sName TEXT,rDay DATETIME,rTime TEXT,Note TEXT,mName TEXT,RegNo TEXT)");

}

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Student");
        DB.execSQL("drop Table if exists Submission");


    }
    
    //insert user data
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


    //insert submission data
    public Boolean insertSub(String sName,String rDay,String rTime,String Note,String mName,String RegNo)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sName", sName);
        contentValues.put("rDay", rDay);
        contentValues.put("rTime", rTime);
        contentValues.put("Note", Note);
        contentValues.put("mName", mName);
        contentValues.put("RegNo", RegNo);


        long result=DB.insert("Submission", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    //get data for profile
    public Cursor getData(String RegNo)
    {
        String query = "SELECT * FROM Student WHERE RegNo =  " + RegNo ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query("Student", new String[]{"ID,RegNo,Pwd,StName,Phone,Email,Date"}, "RegNo = ? ",new String[]{String.valueOf(RegNo)},null, null, null, null);
        return cursor;
    }

    public Cursor getsData ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Submission where RegNo = 'IT19083742' ",null);
        return cursor;
    }

    public Cursor getSub(Integer SID){
        String query = "SELECT * FROM Submission  WHERE SID =  " + SID  ;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.query("Submission", new String[]{"SID,sName,rDay,rTime,Note,mName,RegNo"}, "SID = ? ",new String[]{String.valueOf(SID)},null, null, null, null);
        }
        return cursor;
    }

    //show data
    public Cursor readAllData(String RegNo){
        String query = "SELECT * FROM Submission  WHERE RegNo =  " + RegNo ;
        SQLiteDatabase db = this.getReadableDatabase();
    
        Cursor cursor = null;
        if(db != null){
            cursor = db.query("Submission", new String[]{"SID,sName,rDay,rTime,Note,mName,RegNo"}, "RegNo = ? ",new String[]{String.valueOf(RegNo)},null, null, null, null);
        }
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

    //update password
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
    public Boolean UpdateSub(String ID, String Name, String Day, String Time, String Note, String mName) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sName", Name);
        contentValues.put("rDay", Day);
        contentValues.put("rTime", Time);
        contentValues.put("Note",Note);
        contentValues.put("mName", mName);

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


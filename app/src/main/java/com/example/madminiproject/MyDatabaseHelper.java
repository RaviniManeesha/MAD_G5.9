package com.example.madminiproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Uni.db";
    private static final int DATABASE_VERSION = 1;


    MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE Books(ID INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT,dateB DATE,dateE DATE)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Books");
        onCreate(db);
    }

    //insert data
    public Boolean InsertData(String title, String dateB, String dateE) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("dateB", dateB);
        contentValues.put("dateE", dateE);
        long result = DB.insert("Books", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //update data
    public Boolean UpdateData(Integer ID,String title,String dateB,String dateE) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("dateB", dateB);
        contentValues.put("dateE", dateE);

        Cursor cursor = DB.rawQuery("Select * from Books where ID = ?", new String[]{String.valueOf(ID)});
        if (cursor.getCount() > 0) {
            long result = DB.update("Books", contentValues, "ID=?", new String[]{String.valueOf(ID)});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }}

        //get book details
        public Cursor getData()
        {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery("select * from Books",null);
            return cursor;
        }

    //delete book
    public Boolean deleteBook(Integer ID)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Books where ID = ?", new String[]{String.valueOf(ID)});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Books", "ID=?", new String[]{String.valueOf(ID)});
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

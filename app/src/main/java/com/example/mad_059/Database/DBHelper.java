package com.example.mad_059.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {


    public  static final  String DATABASE_NAME = "UserInfo.db";

    public DBHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String SQL_CREATE_ENTRIES = "CREATE TABLE" + UsersMaster.Users.TABLE_NAME + "(" +
                UsersMaster.Users._ID + "INTEGER PRIMARY KEY," +
                UsersMaster.Users.COLUMN_NAME_REGISTRATION_NO + "TEXT," +
                UsersMaster.Users.COLUMN_NAME_PWD + "TEXT)";

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


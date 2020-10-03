package com.example.attendancecriteria;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Attendance2.db";
    private static final int DATABASE_VERSION =1;

    private static final String TABLE_NAME = "Monday";
    private static final String _ID = "_id";
    private static final String COLUMN_SUB = "subject";
    private static final String COLUMN_Room= "Room";
    private static final String COLUMN_Teacher= "Teacher";
    private static final String COLUMN_Day= "Day";
    private static final String COLUMN_Time= "Time";





    MyDatabaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION );
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        "(" + _ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                               COLUMN_SUB + " TEXT, " +
                                    COLUMN_Room+ " TEXT, " +
                                            COLUMN_Teacher+ " TEXT, " +
                                                    COLUMN_Day + " TEXT,"+
                                                            COLUMN_Time + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addSub(String subject,String Room, String Teacher,String day,String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_SUB, subject);
        cv.put(COLUMN_Room, Room);
        cv.put(COLUMN_Teacher, Teacher);
        cv.put(COLUMN_Day, day);
        cv.put(COLUMN_Time, time);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show();

        }

    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor= db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id,String subject,String room,String teacher,String time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_SUB,subject);
        cv.put(COLUMN_Room,room);
        cv.put(COLUMN_Teacher,teacher);
        cv.put(COLUMN_Time,time);

        long result = db.update(TABLE_NAME, cv, "_id = ?", new String[]{row_id});
        if(result == -1){
           Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Successfully Updated",Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?",new String[]{row_id});
        if(result == -1){
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Successfully Deleted",Toast.LENGTH_SHORT).show();
        }
    }

    void  deleteAllData (){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

}

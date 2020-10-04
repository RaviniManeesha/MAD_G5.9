package com.example.unistudiac;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper{

    private Context context;
    private static final String DATABASE_NAME = "Modules.db" ;
    private static final int DATABASE_VERSION = 1 ;

    private static final String TABLE_NAME = "my_library" ;
    private static final String COLUMN_ID = "id" ;
    private static final String COLUMN_name = "moduleName" ;
    private static final String COLUMN_no = "moduleNo" ;

    private static final String TABLE_NAME2 = "ModuleDetails" ;
    private static final String COLUMN_ID2 = "id2" ;
    private static final String COLUMN_mc = "mcode" ;
    private static final String COLUMN_name2 = "moduleName" ;
    private static final String COLUMN_cr = "credit" ;
    private static final String COLUMN_ca = "ca" ;
    private static final String COLUMN_fn = "final" ;
    private static final String COLUMN_ref = "reference" ;


    MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_name + " TEXT, " +
                        COLUMN_no + " TEXT);";


        String query2 =
                "CREATE TABLE " + TABLE_NAME2 +
                        "(" + COLUMN_ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_mc + " TEXT, " +
                        COLUMN_name2 + " TEXT, " + COLUMN_ca + " TEXT, " + COLUMN_fn + " TEXT, " +
                        COLUMN_cr + " TEXT, " + COLUMN_ref + " TEXT);";
        db.execSQL(query);
        db.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);
    }
    public void addDetails(String name, String code, String cr, String ca, String fn, String ref){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =  new ContentValues();

        cv.put(COLUMN_name2, name);
        cv.put(COLUMN_mc, code);
        cv.put(COLUMN_cr, cr);
        cv.put(COLUMN_ca, ca);
        cv.put(COLUMN_fn, fn);
        cv.put(COLUMN_ref, ref);



        long result = db.insert(TABLE_NAME2, null, cv);

        if(result == -1){
            Toast.makeText(context, "Failed!!!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Data Inserted Successfully!", Toast.LENGTH_SHORT).show();
        }
    }
    public void addModule(String name, String no){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =  new ContentValues();

        cv.put(COLUMN_name, name);
        cv.put(COLUMN_no, no);

        long result = db.insert(TABLE_NAME, null, cv);

        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Data Inserted Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;

        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    //Module Details
    Cursor readAllDetails(){
        String query = "SELECT * FROM " + TABLE_NAME2;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;

        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    //Module
    void updateData(String row_id, String name, String no){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_name, name);
        cv.put(COLUMN_no, no);

        long result = db.update(TABLE_NAME, cv, "id=?", new String[] {row_id});

        if(result == -1){
            Toast.makeText(context, "Failed to Update!", Toast.LENGTH_SHORT).show();
        }else{

            Toast.makeText(context, "Successfully Updated!", Toast.LENGTH_SHORT).show();
        }
    }
    //Modue Details
    void updateDetails(String row_id, String name, String code, String cr, String ca, String fn, String ref){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_name2, name);
        cv.put(COLUMN_mc, code);
        cv.put(COLUMN_cr, cr);
        cv.put(COLUMN_ca, ca);
        cv.put(COLUMN_fn, fn);
        cv.put(COLUMN_ref, ref);

        long result = db.update(TABLE_NAME2, cv, "id=?", new String[] {row_id});

        if(result == -1){
            Toast.makeText(context, "Failed to Update!", Toast.LENGTH_SHORT).show();
        }else{

            Toast.makeText(context, "Successfully Updated!", Toast.LENGTH_SHORT).show();
        }
    }
    //Module
    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "id=?",new String[] {row_id});

        if(result == -1){
            Toast.makeText(context, "Failed Updated!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted!", Toast.LENGTH_SHORT).show();
        }
    }
    //Module Details
    void deleteRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME2, "id=?",new String[] {row_id});

        if(result == -1){
            Toast.makeText(context, "Failed Updated!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted!", Toast.LENGTH_SHORT).show();
        }
    }


}

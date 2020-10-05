package com.example.mad_059.Database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {

    Context context;
    //Attendance
    private static final String TABLE_NAME = "Monday";
    private static final String _ID = "_id";
    private static final String COLUMN_SUB = "subject";
    private static final String COLUMN_Room= "Room";
    private static final String COLUMN_Teacher= "Teacher";
    private static final String COLUMN_Day= "Day";
    private static final String REG_NO= "RegNo";
    private static final String COLUMN_Time= "Time";

    //Modules
    private static final String TABLE_NAME2 = "my_library" ;
    private static final String COLUMN_ID = "id" ;
    private static final String COLUMN_name = "moduleName" ;
    private static final String COLUMN_no = "moduleNo" ;

    private static final String TABLE_NAME3 = "ModuleDetails" ;
    private static final String COLUMN_ID2 = "id2" ;
    private static final String COLUMN_mc = "mcode" ;
    private static final String COLUMN_name2 = "moduleName" ;
    private static final String COLUMN_cr = "credit" ;
    private static final String COLUMN_ca = "ca" ;
    private static final String COLUMN_fn = "final" ;
    private static final String COLUMN_ref = "reference" ;

    //create database
    public DBHelper(Context context) {
        super(context, "Student.db", null, 1);
    }

    //create tables
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Student(ID INTEGER primary key autoincrement,RegNo TEXT, Pwd TEXT, StName TEXT,Phone TEXT,Email EMAIL,Date DATE)");
        DB.execSQL("create Table Submission(SID INTEGER primary key autoincrement,sName TEXT,rDay TEXT,rTime TEXT,Note TEXT,mName TEXT,RegNo TEXT,dates TEXT)");


        //Attendance
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        "(" + _ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_SUB + " TEXT, " +
                        COLUMN_Room+ " TEXT, " +
                        COLUMN_Teacher+ " TEXT, " +
                        COLUMN_Day + " TEXT," +
                        REG_NO + " TEXT ," +
                        COLUMN_Time + " TEXT)";
        DB.execSQL(query);

        //Library
        String query2= "CREATE TABLE Books(ID INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT,dateB DATE,dateE DATE,RegNo TEXT)";
        DB.execSQL(query2);

        //Modules
        String query3 =
                "CREATE TABLE " + TABLE_NAME2 +
                        "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_name + " TEXT, " +
                        COLUMN_no + " TEXT ," +
                        REG_NO + " TEXT ) ";


        String query4 =
                "CREATE TABLE " + TABLE_NAME3+
                        "(" + COLUMN_ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_mc + " TEXT, " +
                        COLUMN_name2 + " TEXT, " + COLUMN_ca + " TEXT, " + COLUMN_fn + " TEXT, " +
                        COLUMN_cr + " TEXT, " + COLUMN_ref + " TEXT ,"  +  REG_NO + " TEXT ) ";;

        DB.execSQL(query4);
        DB.execSQL(query3);
}

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Student");
        DB.execSQL("drop Table if exists Submission");

        //Attendance
       DB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);


        //Library
        DB.execSQL("DROP TABLE IF EXISTS Books");


        //Modules
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);

        onCreate(DB);
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
    public Boolean insertSub(String sName,String rDay,String rTime,String Note,String mName,String RegNo,String dates)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sName", sName);
        contentValues.put("rDay", rDay);
        contentValues.put("rTime", rTime);
        contentValues.put("Note", Note);
        contentValues.put("mName", mName);
        contentValues.put("RegNo", RegNo);
        contentValues.put("dates", dates);


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

    public Cursor login(String RegNo,String Pwd)
    {
        String query = "SELECT * FROM Student WHERE RegNo =  " + RegNo  + " Pwd = " + Pwd;
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

    public Cursor getDate(String RegNo){
        String query = "SELECT strftime(%d %m %Y,day) as date FROM Submission  WHERE RegNo =  " + RegNo ;
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

        //////////////////////////////////Attendance////////////////////////////////////////////


    public Boolean addSub(String subject, String Room, String Teacher, String day,String RegNo,String Time) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();

            cv.put(COLUMN_SUB, subject);
            cv.put(COLUMN_Room, Room);
            cv.put(COLUMN_Teacher, Teacher);
            cv.put(COLUMN_Day, day);
            cv.put(REG_NO ,RegNo);
            cv.put(COLUMN_Time ,Time);

            long result = db.insert(TABLE_NAME, null, cv);
            if (result == -1) {
                return false;
            } else {
                return true;
            }

        }

        public Cursor readAllData2(String RegNo){
            String query = "SELECT * FROM " + TABLE_NAME + " Where RegNo = " + RegNo;
            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = null;
            if(db != null){
                cursor = db.query( "Monday", new String[]{"_id,subject,Room,Teacher,Day,RegNo,Time"}, "RegNo = ? ",
                        new String[]{String.valueOf(RegNo)},null, null, null, null);
            }
            return cursor;
        }

    public Boolean updateData2(String row_id, String subject, String room, String teacher,String Time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_SUB,subject);
        cv.put(COLUMN_Room,room);
        cv.put(COLUMN_Teacher,teacher);
        cv.put(COLUMN_Time,Time);

        long result = db.update(TABLE_NAME, cv, "_id = ?", new String[]{row_id});
        if(result == -1){
            return false;
        }else{
            return  true;
        }
    }

    public boolean deleteOneRow2(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?",new String[]{row_id});
        if(result == -1){
            return false;
        }else{
            return  true;
        }
    }

    public void  deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

    /////////////////////////////////////Library/////////////////////////////
    //insert data
    public Boolean InsertData3(String title, String dateB, String dateE,String RegNo) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("dateB", dateB);
        contentValues.put("dateE", dateE);
        contentValues.put("RegNo",RegNo);
        long result = DB.insert("Books", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    //update data
    public Boolean UpdateData3(Integer ID,String title,String dateB,String dateE) {
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
    public Cursor getData3(String RegNo)
    {
        String query = "SELECT * FROM Books" + "Where RegNo = " + RegNo ;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.query( "Books", new String[]{"ID,title,dateB,dateE,RegNo"}, "RegNo = ? ",new String[]{String.valueOf(RegNo)},null, null, null, null);
        }
        return cursor;
    }

    //delete book
    public Boolean deleteBook3(Integer ID)
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


    //////////////////////////////////Modules//////////////////////////////
    public boolean addDetails4(String name, String code, String cr, String ca, String fn, String ref,String RegNo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =  new ContentValues();

        cv.put(COLUMN_name2, name);
        cv.put(COLUMN_mc, code);
        cv.put(COLUMN_cr, cr);
        cv.put(COLUMN_ca, ca);
        cv.put(COLUMN_fn, fn);
        cv.put(COLUMN_ref, ref);
        cv.put(REG_NO, RegNo);

        long result = db.insert(TABLE_NAME3, null, cv);

        if(result == -1){

            return false;
        }
        else{

            return true;
        }
    }

    public boolean addModule4(String name, String no,String RegNo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =  new ContentValues();

        cv.put(COLUMN_name, name);
        cv.put(COLUMN_no, no);
        cv.put(REG_NO,RegNo);

        long result = db.insert(TABLE_NAME2, null, cv);

        if(result == -1){
           return false;
        }
        else{
            return true;
        }
    }

    public Cursor readAllData4(String RegNo){
        String query = "SELECT * FROM " + TABLE_NAME2 + "Where RegNo = " + RegNo;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;

        if(db != null){
            cursor = db.query( "my_library", new String[]{"id,moduleName,moduleNo,RegNo"}, "RegNo = ? ",new String[]{String.valueOf(RegNo)},null, null, null, null);
        }
        return cursor;
    }

    public Cursor readAllDetails4(String RegNo){
        String query = "SELECT * FROM " + TABLE_NAME3 + "Where RegNo = " + RegNo;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;

        if(db != null){
            cursor = db.query( "ModuleDetails", new String[]{"id2,name,code,cr,ca,fn,ref,RegNo"}, "RegNo = ? ",new String[]{String.valueOf(RegNo)},null, null, null, null);
        }
        return cursor;
    }

   public Boolean updateData4( String row_id, String name, String no){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_name, name);
        cv.put(COLUMN_no, no);


        long result = db.update(TABLE_NAME2, cv, "id=?", new String[] {row_id});

        if(result == -1){
         return  false;
        }else{

            return true;
        }
   }
    public void updateDetails4(String row_id, String name, String code, String cr, String ca, String fn, String ref){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_name2, name);
        cv.put(COLUMN_mc, code);
        cv.put(COLUMN_cr, cr);
        cv.put(COLUMN_ca, ca);
        cv.put(COLUMN_fn, fn);
        cv.put(COLUMN_ref, ref);

        long result = db.update(TABLE_NAME3, cv, "id=?", new String[] {row_id});

        if(result == -1){
            Toast.makeText(context, "Failed to Update!", Toast.LENGTH_SHORT).show();
        }else{

            Toast.makeText(context, "Successfully Updated!", Toast.LENGTH_SHORT).show();
        }
    }
////////////////
public Boolean deleteOneRow4(String row_id){

        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME2, "id=?",new String[] {row_id});
        if(result == -1){
            return  false;
        }else{
            return true;
        }

}


}


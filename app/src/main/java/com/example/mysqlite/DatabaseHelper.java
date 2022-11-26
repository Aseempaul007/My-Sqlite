package com.example.mysqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mysqlite.modelClass.ModelDataClass;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Students.db";
    public static final String TABLE_NAME = "Student_table";
    private static final int DATABASE_VERSION = 1;
    public static final String COL_ID = "ID";
    public static final String COL_NAME = "NAME";
    public static final String COL_PHONE_NO = "PHONE_NO";

    ArrayList<ModelDataClass> arrayList = new ArrayList();
    ModelDataClass modelDataClass = new ModelDataClass();


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NAME
        + " STRING," + COL_PHONE_NO + " STRING" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public void insertData(String name, String phoneNumber){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME,name);
        contentValues.put(COL_PHONE_NO,phoneNumber);

        db.insert(TABLE_NAME,null,contentValues);
    }

    public void updateData(ModelDataClass mdc){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_NAME,mdc.getName());
        contentValues.put(COL_PHONE_NO,mdc.getMobileNumber());
        db.update(TABLE_NAME,contentValues, COL_ID+" = " + mdc.getId(),null);
    }

    public void deleteData(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();

        db.delete(TABLE_NAME,COL_ID+" = ? ",new String[]{String.valueOf(id)});
    }


    public ArrayList<ModelDataClass> showData(){

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        while(cursor.moveToNext()){
            ModelDataClass modelDataClass = new ModelDataClass(
                    cursor.getInt(0), cursor.getString(1), cursor.getString(2)
            );
            arrayList.add(modelDataClass);
        }
        return arrayList;
    }
}

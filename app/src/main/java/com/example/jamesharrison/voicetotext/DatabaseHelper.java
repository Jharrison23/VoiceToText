package com.example.jamesharrison.voicetotext;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jamesharrison on 1/12/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "notes.db";
    public static final String TABLE_NAME  = "Notes";
    public static final String COL1 = "ID";
    public static final String COL2 = "NOTETITLE";
    public static final String COL3 = "NOTEDATE";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createTable = "CREATE TABLE " + TABLE_NAME + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " NOTETITLE TEXT, NOTEDATE TEXT) ";//  TEXT default CURRENT_TIMESTAMP) ";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP IF TABLE EXIST " +  TABLE_NAME);

        onCreate(db);

    }



    public boolean addData(String noteTitle, String noteDate)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COL2,noteTitle);
        values.put(COL3, noteDate);//" TEXT default CURRENT_TIMESTAMP");

        long result = db.insert(TABLE_NAME, null, values);

        if(result == -1)
        {
            return false;
        }

        else
        {
            return true;
        }
    }


    public Cursor getListContents()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        return data;
    }

}

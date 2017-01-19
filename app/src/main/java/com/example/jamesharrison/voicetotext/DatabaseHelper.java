package com.example.jamesharrison.voicetotext;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jamesharrison on 1/12/17.
 */

// Class which will store information for sqlite database
public class DatabaseHelper extends SQLiteOpenHelper
{
    // Set database name
    public static final String DATABASE_NAME = "notes.db";

    // Table name in the database
    public static final String TABLE_NAME  = "Notes";

    //Tabe elements, ID, note title, note date, note content
    public static final String COL1 = "ID";
    public static final String COL2 = "NOTETITLE";
    public static final String COL3 = "NOTEDATE";
    public static final String COL4 = "NOTECONTENT";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // Create the database table, with the
        // id being type auto incrementing integer,
        // and the title date and content being text
        String createTable = "CREATE TABLE " + TABLE_NAME + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " NOTETITLE TEXT, NOTEDATE TEXT," + " NOTECONTENT TEXT) ";//  TEXT default CURRENT_TIMESTAMP) ";

        // Create database table
        db.execSQL(createTable);
    }

    // This method is called when database is upgraded like modifying the table structure, adding constraints to database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP IF TABLE EXIST " +  TABLE_NAME);

        onCreate(db);

    }

    // Method to delete data in the table given the id, this method returns an integer greater than
    // zero if the deletion is successful
    public Integer deleteData(String id)
    {
        // Open the database to allow writing to it
        SQLiteDatabase db = this.getWritableDatabase();

        // Return an integer which represents whether or not the deletion was successful
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});
    }


    // Method which adds data to the database, returns true if the add was successful
    public boolean addData(String noteTitle, String noteDate, String noteContent)
    {
        // Open the database and allow writing to it
        SQLiteDatabase db = this.getWritableDatabase();

        // Create an empty set of values using the default initial size
        ContentValues values = new ContentValues();

        // Put the title of the note into col2 of the database
        values.put(COL2,noteTitle);

        // put the date of the note in col3 of the database
        values.put(COL3, noteDate);

        // put the content of the note in col4 of the database
        values.put(COL4, noteContent);

        // try to insert data into the database if this returns a 1 the insertion failed
        long result = db.insert(TABLE_NAME, null, values);

        // if the insertion failed
        if(result == -1)
        {
            return false;
        }

        // if the insertion was successful
        else
        {
            return true;
        }
    }


    // Method which returns a cursor to get the contents from the table in the database
    public Cursor getListContents()
    {
        // open the database for read / write access
        SQLiteDatabase db = this.getWritableDatabase();

        // save the entire database table (Select *) into the cursor data
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // return the entire contents of the database table
        return data;
    }

}

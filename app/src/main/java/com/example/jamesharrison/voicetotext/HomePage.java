package com.example.jamesharrison.voicetotext;

import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity
{

    DatabaseHelper myDB;

    // Declared UI elements to be used on this view
    FloatingActionButton addNewNote;

    ListView notesList;

    // Create an Array List which will store the notes in the database
    ArrayList<Note> notesArrayList;

    // Variable of type Note, to add to the notesArrayList
    Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Call the method to initialize the UI elements
        initialize();
    }

    public void initialize()
    {
        // Initialize the floating action button and link it to the addNewNote Button
        addNewNote = (FloatingActionButton) findViewById(R.id.addNewNote);

        // Initialize the list view and link it to the notesList List View
        notesList = (ListView) findViewById(R.id.notesList);

        myDB = new DatabaseHelper(this);

        notesArrayList = new ArrayList<Note>();

        Cursor data = myDB.getListContents();

        int numRows = data.getCount();

        if(numRows == 0)
        {
            Toast.makeText(this, "The database is empty", Toast.LENGTH_SHORT).show();
        }

        else
        {
            while (data.moveToNext())
            {
                note = new Note(data.getString(1), data.getString(2));

                notesArrayList.add(note);
            }

            ListAdapterView adapter = new ListAdapterView(this, R.layout.activity_list_adapter_view, notesArrayList);

            notesList.setAdapter(adapter);
        }
    }
}

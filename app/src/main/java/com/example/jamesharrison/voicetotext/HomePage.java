package com.example.jamesharrison.voicetotext;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;


// Class which will display the notes currently in the database which were entered by the user
public class HomePage extends AppCompatActivity implements View.OnClickListener
{

    // variable for creating an instance of database helper
    DatabaseHelper myDB;

    // Declared UI elements to be used on this view
    FloatingActionButton addNewNote;

    ListView notesList;

    // Create an Array List which will store the notes in the database
    ArrayList<Note> notesArrayList;

    // Variable of type Note, to add to the notesArrayList
    Note note;

    // once the view is first created
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // The xml for this activity
        setContentView(R.layout.activity_home_page);

        // Call the method to initialize the UI elements
        initialize();
    }

    public void initialize()
    {
        // Initialize the floating action button and link it to the addNewNote Button
        addNewNote = (FloatingActionButton) findViewById(R.id.addNewNote);
        addNewNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Go to the New note activity
                Intent intent = new Intent(HomePage.this, NewNote.class);
                startActivity(intent);
            }
        });


        // Initialize the list view and link it to the notesList List View
        notesList = (ListView) findViewById(R.id.notesList);

        // instance of database helper
        myDB = new DatabaseHelper(this);

        // create arraylist of type note
        notesArrayList = new ArrayList<Note>();

        // create a cursor to return a reference to the database method getListContents
        Cursor data = myDB.getListContents();

        // get the number of rows in the database
        int numRows = data.getCount();

        // if the number of rows in the database is 0 then it is empty
        if(numRows == 0)
        {
            Toast.makeText(this, "The database is empty", Toast.LENGTH_SHORT).show();
        }

        // if the database is not empty
        else
        {
            // loop through all of the elements
            while (data.moveToNext())
            {
                // add each entry of the database into the array list notesArray list
                note = new Note(data.getString(0), data.getString(1), data.getString(2), data.getString(3));
                notesArrayList.add(note);
            }

            // create an instance of the listAdapterView and pass in the notes array list
            ListAdapterView adapter = new ListAdapterView(this, R.layout.activity_list_adapter_view, notesArrayList);

            // set the adapter for the list view to the custom ListAdapterView
            notesList.setAdapter(adapter);

            // When an item on the list view is clicked
            notesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    // Create a new note from the arraylist, at index position
                    Note note = notesArrayList.get(position);

                    // Create an intent to move to the class NoteView
                    Intent intent = new Intent(HomePage.this, NoteView.class);

                    // Create a bundle, which allows us to bundle our information together to pass to another class
                    Bundle bundle = new Bundle();

                    // Add a string to the bundle, "ID" is a tag to identify what we passed but note.getNoteID is what we are passing
                    bundle.putString("ID", note.getNoteID());

                    // Add the note title to the bundle
                    bundle.putString("NoteName", note.getNoteTitle());

                    // Add the note date to the bundle
                    bundle.putString("NoteDate", note.getNoteDate());

                    // Add the note content to the bundle
                    bundle.putString("NoteContent", note.getNoteContent());

                    // put the bundle in the intent
                    intent.putExtras(bundle);

                    // Start the activity and move to the next class
                    startActivity(intent);
                }
            });





        }
    }

    // Once a button on the view is clicked
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            // If the add new button is clicked
            case R.id.addNewNote:

                // Go to the New note activity
                Intent intent = new Intent(HomePage.this, NewNote.class);
                startActivity(intent);
                break;
        }

    }
}
